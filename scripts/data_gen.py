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


gen_wood_carpentry_table_recipes('oak')
gen_wood_carpentry_table_recipes('spruce')
gen_wood_carpentry_table_recipes('birch')
gen_wood_carpentry_table_recipes('jungle')
gen_wood_carpentry_table_recipes('acacia')
gen_wood_carpentry_table_recipes('dark_oak')
gen_wood_carpentry_table_recipes('mangrove')
gen_wood_carpentry_table_recipes('crimson', log='stem')
gen_wood_carpentry_table_recipes('warped', log='stem')
