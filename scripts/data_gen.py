# Generates json files in the common module.
# Should probably be replaced by Forge and/or Fabric data gen.

def gen_carpentry_table_recipe(ingredient_mod, ingredient, result_mod, result, count):
    with open(f'../Common/src/main/resources/data/crumbs/recipes/carpentry_table/{result}_from_{ingredient}.json', 'w') as file:
        file.write('{\n')
        file.write('\t"type": "crumbs:carpentry_table",\n')
        file.write(f'\t"count": {count},\n')
        file.write('\t"ingredient": {\n')
        file.write(f'\t\t"item": "{ingredient_mod}:{ingredient}"\n')
        file.write('\t},\n')
        file.write(f'\t"result": "{result_mod}:{result}"\n')
        file.write('}\n')


def gen_wood_carpentry_table_recipes(wood, log='log'):
    gen_carpentry_table_recipe('minecraft', f'{wood}_planks', 'minecraft', f'{wood}_button', 4)
    gen_carpentry_table_recipe('minecraft', f'{wood}_planks', 'minecraft', f'{wood}_door', 1)
    gen_carpentry_table_recipe('minecraft', f'{wood}_planks', 'minecraft', f'{wood}_fence', 1)
    gen_carpentry_table_recipe('minecraft', f'{wood}_planks', 'minecraft', f'{wood}_fence_gate', 1)
    gen_carpentry_table_recipe('minecraft', f'{wood}_planks', 'minecraft', f'{wood}_pressure_plate', 2)
    gen_carpentry_table_recipe('minecraft', f'{wood}_planks', 'minecraft', f'{wood}_sign', 1)
    gen_carpentry_table_recipe('minecraft', f'{wood}_planks', 'minecraft', f'{wood}_slab', 2)
    gen_carpentry_table_recipe('minecraft', f'{wood}_planks', 'minecraft', f'{wood}_stairs', 1)
    gen_carpentry_table_recipe('minecraft', f'{wood}_planks', 'minecraft', f'{wood}_trapdoor', 1)

    gen_carpentry_table_recipe('minecraft', f'{wood}_{log}', 'minecraft', f'{wood}_planks', 6)
    gen_carpentry_table_recipe('minecraft', f'{wood}_{log}', 'minecraft', f'stripped_{wood}_{log}', 1)
    gen_carpentry_table_recipe('minecraft', f'stripped_{wood}_{log}', 'minecraft', f'{wood}_planks', 6)

    gen_carpentry_table_recipe('minecraft', f'{wood}_{log}', 'crumbs', f'{wood}_post', 1)
    gen_carpentry_table_recipe('minecraft', f'{wood}_{log}', 'crumbs', f'stripped_{wood}_post', 1)
    gen_carpentry_table_recipe('minecraft', f'stripped_{wood}_{log}', 'crumbs', f'stripped_{wood}_post', 1)


gen_wood_carpentry_table_recipes('oak')
gen_wood_carpentry_table_recipes('spruce')
gen_wood_carpentry_table_recipes('birch')
gen_wood_carpentry_table_recipes('jungle')
gen_wood_carpentry_table_recipes('acacia')
gen_wood_carpentry_table_recipes('dark_oak')
gen_wood_carpentry_table_recipes('mangrove')
gen_wood_carpentry_table_recipes('crimson', log='stem')
gen_wood_carpentry_table_recipes('warped', log='stem')


def gen_wood_post_block_state(wood):
    with open(f'../Common/src/main/resources/assets/crumbs/blockstates/{wood}_post.json', 'w') as file:
        file.write(f'''{{
    "multipart": [
        {{
            "apply": {{
                "model": "crumbs:block/{wood}_post"
            }},
            "when": {{
                "up": "true"
            }}
        }},
        {{
            "apply": {{
                "model": "crumbs:block/{wood}_post_side",
                "uvlock": true
            }},
            "when": {{
                "north": "low"
            }}
        }},
        {{
            "apply": {{
                "model": "crumbs:block/{wood}_post_side",
                "uvlock": true,
                "y": 90
            }},
            "when": {{
                "east": "low"
            }}
        }},
        {{
            "apply": {{
                "model": "crumbs:block/{wood}_post_side",
                "uvlock": true,
                "y": 180
            }},
            "when": {{
                "south": "low"
            }}
        }},
        {{
            "apply": {{
                "model": "crumbs:block/{wood}_post_side",
                "uvlock": true,
                "y": 270
            }},
            "when": {{
                "west": "low"
            }}
        }},
        {{
            "apply": {{
                "model": "crumbs:block/{wood}_post_side_tall",
                "uvlock": true
            }},
            "when": {{
                "north": "tall"
            }}
        }},
        {{
            "apply": {{
                "model": "crumbs:block/{wood}_post_side_tall",
                "uvlock": true,
                "y": 90
            }},
            "when": {{
                "east": "tall"
            }}
        }},
        {{
            "apply": {{
                "model": "crumbs:block/{wood}_post_side_tall",
                "uvlock": true,
                "y": 180
            }},
            "when": {{
                "south": "tall"
            }}
        }},
        {{
            "apply": {{
                "model": "crumbs:block/{wood}_post_side_tall",
                "uvlock": true,
                "y": 270
            }},
            "when": {{
                "west": "tall"
            }}
        }}
    ]
}}
''')


def gen_wood_post_models(wood, log='log'):
    with open(f'../Common/src/main/resources/assets/crumbs/models/block/{wood}_post.json', 'w') as file:
        file.write(f'''{{
    "parent": "crumbs:block/template_post",
    "textures": {{
        "post": "minecraft:block/{wood}_{log}",
        "top": "crumbs:block/{wood}_post_top"
    }}
}}
''')

    with open(f'../Common/src/main/resources/assets/crumbs/models/block/{wood}_post_side.json', 'w') as file:
        file.write(f'''{{
    "parent": "minecraft:block/template_wall_side",
    "textures": {{
        "wall": "crumbs:block/{wood}_post_side"
    }}
}}
''')

    with open(f'../Common/src/main/resources/assets/crumbs/models/block/{wood}_post_side_tall.json', 'w') as file:
        file.write(f'''{{
    "parent": "minecraft:block/template_wall_side_tall",
    "textures": {{
        "wall": "crumbs:block/{wood}_post_side"
    }}
}}
''')

    with open(f'../Common/src/main/resources/assets/crumbs/models/item/{wood}_post.json', 'w') as file:
        file.write(f'''{{
    "parent": "crumbs:block/template_post_inventory",
    "textures": {{
        "post": "minecraft:block/{wood}_{log}",
        "side": "crumbs:block/{wood}_post_side",
        "top": "crumbs:block/{wood}_post_top"
    }}
}}
''')


def gen_post_recipe(wood, log='log', stripped=False):
    with open(f'../Common/src/main/resources/data/crumbs/recipes/{wood}_post.json', 'w') as file:
        file.write('{\n')
        file.write('\t"type": "minecraft:crafting_shaped",\n')
        if stripped:
            file.write('\t"group": "crumbs:stripped_wooden_post",\n')
        else:
            file.write('\t"group": "crumbs:wooden_post",\n')
        file.write('\t"key": {\n')
        file.write('\t\t"#": {\n')
        file.write(f'\t\t\t"item": "minecraft:{wood}_{log}"\n')
        file.write('\t\t}\n')
        file.write('\t},\n')
        file.write('\t"pattern": [\n')
        file.write('\t\t"###",\n')
        file.write('\t\t"###"\n')
        file.write('\t],\n')
        file.write('\t"result": {\n')
        file.write(f'\t\t"item": "crumbs:{wood}_post",\n')
        file.write('\t\t"count": 6\n')
        file.write('\t}\n')
        file.write('}\n')


def gen_wood_post(wood, log='log', stripped=False):
    gen_wood_post_block_state(wood)
    gen_wood_post_models(wood, log)
    gen_post_recipe(wood, log, stripped)


gen_wood_post('oak')
gen_wood_post('spruce')
gen_wood_post('birch')
gen_wood_post('jungle')
gen_wood_post('acacia')
gen_wood_post('dark_oak')
gen_wood_post('mangrove')
gen_wood_post('crimson', log='stem')
gen_wood_post('warped', log='stem')

gen_wood_post('stripped_oak', stripped=True)
gen_wood_post('stripped_spruce', stripped=True)
gen_wood_post('stripped_birch', stripped=True)
gen_wood_post('stripped_jungle', stripped=True)
gen_wood_post('stripped_acacia', stripped=True)
gen_wood_post('stripped_dark_oak', stripped=True)
gen_wood_post('stripped_mangrove', stripped=True)
gen_wood_post('stripped_crimson', log='stem', stripped=True)
gen_wood_post('stripped_warped', log='stem', stripped=True)
