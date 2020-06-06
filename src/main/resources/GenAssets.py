try:
    from tkinter import *
    from tkinter import ttk
    from tkinter import messagebox
except:
    from Tkinter import *
    from Tkinter import ttk
    from Tkinter import messagebox
import DefaultConfig as setup
import json

window = Tk()
window.geometry(f"+{int(window.winfo_screenwidth() / 2 - 207)}+{int(window.winfo_screenheight() / 2 - 330)}")
window.title("Minecraft JSON Generator")
window.resizable(False, False)

menuText = StringVar(value = "Not Rotatable - Cube")
blockName = StringVar()
optionBlock = BooleanVar(value = setup.Block)
optionBlockstate = StringVar(value = setup.Blockstate)
optionSlabs = BooleanVar(value = setup.Slabs)
optionStairs = BooleanVar(value = setup.Stairs)
optionWalls = BooleanVar(value = setup.Walls)
optionFences = BooleanVar(value = setup.Fences)
optionPanes = BooleanVar(value = setup.Panes)
optionButtons = BooleanVar(value = setup.Buttons)
optionPlates = BooleanVar(value = setup.Plates)
optionDoors = BooleanVar(value = setup.Doors)

optionCollectionWood = BooleanVar(value = setup.collectionWood)
optionCollectionStone = BooleanVar(value = setup.collectionStone)
optionCollectionStonePlus = BooleanVar(value = setup.collectionStonePlus)
optionCollectionGlass = BooleanVar(value = setup.collectionGlass)
optionCollectionColour = BooleanVar(value = setup.collectionColour)

optionPlural = BooleanVar(value = setup.depluralize)
optionWrite = BooleanVar(value = setup.overwrite)

colours = ["black","blue","brown","cyan","gray","green","light_blue","light_grey",
           "lime","magenta","orange","pink","purple","red","white","yellow"]


def formatString(stringvar):
    string = stringvar.get()
    string = string.lower().replace(" ", "_")
    return string


def depluralize(string):
    if(string[-1] == "s" and setup.depluralize):
        string = string[:-1]
    return string


def updateRadio():
    if(optionBlockstate.get() == "cube"):
        menuText.set("Not Rotatable - Cube")
    elif (optionBlockstate.get() == "cube_column"):
        menuText.set("Not Rotatable - Cube Column")
    elif (optionBlockstate.get() == "cube_bottom_top"):
        menuText.set("Not Rotatable - CubeBottomTop")
    elif (optionBlockstate.get() == "orientable"):
        menuText.set("Not Rotatable - Orientable")
    elif (optionBlockstate.get() == "rotatable_three"):
        menuText.set("Three Way Rotatable (Axis)")
    elif (optionBlockstate.get() == "rotatable_four"):
        menuText.set("Four Way Rotatable (Horizontal)")
    elif (optionBlockstate.get() == "rotatable_six"):
        menuText.set("Six Way Rotatable")
    elif (optionBlockstate.get() == "cross"):
        menuText.set("Cross Model")
    elif (optionBlockstate.get() == "item"):
        menuText.set("No Block - 2D Item Only")


def createFiles(type, name):
    if(optionWrite.get()): write = "w"
    else: write = "x"
    try:
        if(type == "cube"):
            with open(f"assets/{setup.modID}/blockstates/{name}.json", write) as file:
                json.dump({"variants": {"": { "model": f"{setup.modID}:block/{name}" }}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}.json", write) as file:
                json.dump({"parent": "block/cube_all","textures": {"all": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{name}.json", write) as file:
                json.dump({"parent": f"{setup.modID}:block/{name}"}, file, indent = 4)
        elif(type == "cube_column"):
            with open(f"assets/{setup.modID}/blockstates/{name}.json", write) as file:
                json.dump({"variants": {"": { "model": f"{setup.modID}:block/{name}" }}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}.json", write) as file:
                json.dump({"parent": "block/cube_column","textures": {"end": f"{setup.modID}:block/{name}_top","side": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{name}.json", write) as file:
                json.dump({"parent": f"{setup.modID}:block/{name}"}, file, indent = 4)
        elif(type == "cube_bottom_top"):
            with open(f"assets/{setup.modID}/blockstates/{name}.json", write) as file:
                json.dump({"variants": {"": { "model": f"{setup.modID}:block/{name}" }}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}.json", write) as file:
                json.dump({"parent": "block/cube_bottom_top","textures": {"bottom": f"{setup.modID}:block/{name}_bottom","top": f"{setup.modID}:block/{name}_top","side": f"{setup.modID}:block/{name}_side"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{name}.json", write) as file:
                json.dump({"parent": f"{setup.modID}:block/{name}"}, file, indent = 4)
        elif(type == "orientable"):
            with open(f"assets/{setup.modID}/blockstates/{name}.json", write) as file:
                json.dump({"variants": {"": { "model": f"{setup.modID}:block/{name}" }}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}.json", write) as file:
                json.dump({"parent": "block/orientable_with_bottom","textures": {"bottom": f"{setup.modID}:block/{name}_bottom","top": f"{setup.modID}:block/{name}_top","front": f"{setup.modID}:block/{name}_front","side": f"{setup.modID}:block/{name}_side"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{name}.json", write) as file:
                json.dump({"parent": f"{setup.modID}:block/{name}"}, file, indent = 4)
        elif(type[10:] == "three"):
            with open(f"assets/{setup.modID}/blockstates/{name}.json", write) as file:
                json.dump({"variants": {"axis=y":  { "model": f"{setup.modID}:block/{name}" },"axis=z":   { "model": f"{setup.modID}:block/{name}", "x": 90 },"axis=x":   { "model": f"{setup.modID}:block/{name}", "x": 90, "y": 90 }}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}.json", write) as file:
                json.dump({"parent": "block/cube_column","textures": {"end": f"{setup.modID}:block/{name}_top","side": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            #with open(f"assets/{setup.modID}/models/block/{name}_horizontal.json", write) as file:
                #json.dump({"parent": "block/cube_column_horizontal","textures": {"end": f"{setup.modID}:block/{name}_top","side": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{name}.json", write) as file:
                json.dump({"parent": f"{setup.modID}:block/{name}"}, file, indent = 4)
        elif(type[10:] == "four"):
            with open(f"assets/{setup.modID}/blockstates/{name}.json", write) as file:
                json.dump({"variants": {"facing=south": { "model": f"{setup.modID}:block/{name}" },"facing=west": { "model": f"{setup.modID}:block/{name}", "y": 90 },"facing=north": { "model": f"{setup.modID}:block/{name}", "y": 180 },"facing=east": { "model": f"{setup.modID}:block/{name}", "y": 270 }}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}.json", write) as file:
                json.dump({"parent": "block/orientable_with_bottom","textures": {"bottom": f"{setup.modID}:block/{name}_bottom","top": f"{setup.modID}:block/{name}_top","front": f"{setup.modID}:block/{name}_front","side": f"{setup.modID}:block/{name}_side"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{name}.json", write) as file:
                json.dump({"parent": f"{setup.modID}:block/{name}"}, file, indent = 4)
        elif(type[10:] == "six"):
            with open(f"assets/{setup.modID}/blockstates/{name}.json", write) as file:
                json.dump({"variants": {"facing=down":  { "model": f"{setup.modID}:block/{name}_vertical", "x": 180 },"facing=up":    { "model": f"{setup.modID}:block/{name}_vertical" },"facing=north": { "model": f"{setup.modID}:block/{name}" },"facing=south": { "model": f"{setup.modID}:block/{name}", "y": 180 },"facing=west":  { "model": f"{setup.modID}:block/{name}", "y": 270 },"facing=east":  { "model": f"{setup.modID}:block/{name}", "y": 90 }}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}.json", write) as file:
                json.dump({"parent": "block/orientable","textures": {"top": f"{setup.modID}:block/{name}_top","front": f"{setup.modID}:block/{name}_front","side": f"{setup.modID}:block/{name}_side"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}_vertical.json", write) as file:
                json.dump({"parent": "block/orientable_vertical","textures": {"front": f"{setup.modID}:block/{name}_front","side": f"{setup.modID}:block/{name}_top"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{name}.json", write) as file:
                json.dump({"parent": f"{setup.modID}:block/{name}"}, file, indent = 4)
        elif(type == "cross"):
            with open(f"assets/{setup.modID}/blockstates/{name}.json", write) as file:
                json.dump({"variants": {"": { "model": f"{setup.modID}:block/{name}" }}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}.json", write) as file:
                json.dump({"parent": "block/cross","textures": {"cross": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{name}.json", write) as file:
                json.dump({"parent": "item/generated","textures": {"layer0": f"{setup.modID}:block/{name}"}}, file, indent = 4)
        elif(type == "item"):
            with open(f"assets/{setup.modID}/models/item/{name}.json", write) as file:
                json.dump({"parent": "item/generated","textures": {"layer0": f"{setup.modID}:item/{name}"}}, file, indent = 4)

        elif(type == "slabs"):
            if(not optionCollectionWood):
                with open(f"assets/{setup.modID}/blockstates/{depluralize(name)}_slab.json", write) as file:
                    json.dump({"variants": {"type=bottom": { "model": f"{setup.modID}:block/{depluralize(name)}_slab" },"type=top": { "model": f"{setup.modID}:block/{depluralize(name)}_slab_top" },"type=double": { "model": f"{setup.modID}:block/{name}" }}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_slab.json", write) as file:
                    json.dump({"parent": "block/slab","textures": {"bottom": f"{setup.modID}:block/{name}","top": f"{setup.modID}:block/{name}","side": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_slab_top.json", write) as file:
                    json.dump({"parent": "block/slab_top","textures": {"bottom": f"{setup.modID}:block/{name}","top": f"{setup.modID}:block/{name}","side": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/item/{depluralize(name)}_slab.json", write) as file:
                    json.dump({"parent": f"{setup.modID}:block/{depluralize(name)}_slab"}, file, indent = 4)
            else:
                with open(f"assets/{setup.modID}/blockstates/{depluralize(name)}_slab.json", write) as file:
                    json.dump({"variants": {"type=bottom": {"model": f"{setup.modID}:block/{depluralize(name)}_slab"},"type=top": {"model": f"{setup.modID}:block/{depluralize(name)}_slab_top"},"type=double": {"model": f"{setup.modID}:block/{name}"}}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_slab.json", write) as file:
                    json.dump({"parent": "block/slab","textures": {"bottom": f"{setup.modID}:block/{name}", "top": f"{setup.modID}:block/{name}","side": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_slab_top.json", write) as file:
                    json.dump({"parent": "block/slab_top","textures": {"bottom": f"{setup.modID}:block/{name}", "top": f"{setup.modID}:block/{name}","side": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/item/{depluralize(name)}_slab.json", write) as file:
                    json.dump({"parent": f"{setup.modID}:block/{depluralize(name)}_slab"}, file, indent = 4)
        elif(type == "stairs"):
            if(not optionCollectionWood.get()):
                with open(f"assets/{setup.modID}/blockstates/{depluralize(name)}_stairs.json", write) as file:
                    json.dump({"variants": {"facing=east,half=bottom,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs"},"facing=west,half=bottom,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "y": 180,"uvlock": True}, "facing=south,half=bottom,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "y": 90, "uvlock": True},"facing=north,half=bottom,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "y": 270,"uvlock": True}, "facing=east,half=bottom,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer"},"facing=west,half=bottom,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 180,"uvlock": True}, "facing=south,half=bottom,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 90, "uvlock": True},"facing=north,half=bottom,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 270,"uvlock": True}, "facing=east,half=bottom,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 270, "uvlock": True},"facing=west,half=bottom,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 90,"uvlock": True}, "facing=south,half=bottom,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer"},"facing=north,half=bottom,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 180,"uvlock": True}, "facing=east,half=bottom,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner"},"facing=west,half=bottom,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 180,"uvlock": True}, "facing=south,half=bottom,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 90, "uvlock": True},"facing=north,half=bottom,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 270,"uvlock": True}, "facing=east,half=bottom,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 270, "uvlock": True},"facing=west,half=bottom,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 90,"uvlock": True}, "facing=south,half=bottom,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner"},"facing=north,half=bottom,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 180,"uvlock": True}, "facing=east,half=top,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "x": 180, "uvlock": True},"facing=west,half=top,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "x": 180,"y": 180, "uvlock": True}, "facing=south,half=top,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "x": 180, "y": 90, "uvlock": True},"facing=north,half=top,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "x": 180,"y": 270, "uvlock": True}, "facing=east,half=top,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 90,"uvlock": True}, "facing=west,half=top,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 270,"uvlock": True}, "facing=south,half=top,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 180,"uvlock": True}, "facing=north,half=top,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "uvlock": True},"facing=east,half=top,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180,"uvlock": True}, "facing=west,half=top,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 180,"uvlock": True}, "facing=south,half=top,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 90,"uvlock": True}, "facing=north,half=top,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 270,"uvlock": True}, "facing=east,half=top,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 90,"uvlock": True}, "facing=west,half=top,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 270,"uvlock": True}, "facing=south,half=top,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 180,"uvlock": True}, "facing=north,half=top,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "uvlock": True},"facing=east,half=top,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180,"uvlock": True}, "facing=west,half=top,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 180,"uvlock": True}, "facing=south,half=top,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 90,"uvlock": True}, "facing=north,half=top,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 270,"uvlock": True}}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_stairs.json", write) as file:
                    json.dump({"parent": "block/stairs","textures": {"bottom": f"{setup.modID}:block/{name}","top": f"{setup.modID}:block/{name}","side": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_stairs_inner.json", write) as file:
                    json.dump({"parent": "block/inner_stairs","textures": {"bottom": f"{setup.modID}:block/{name}","top": f"{setup.modID}:block/{name}","side": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_stairs_outer.json", write) as file:
                    json.dump({"parent": "block/outer_stairs","textures": {"bottom": f"{setup.modID}:block/{name}","top": f"{setup.modID}:block/{name}","side": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/item/{depluralize(name)}_stairs.json", write) as file:
                    json.dump({"parent": f"{setup.modID}:block/{depluralize(name)}_stairs"}, file, indent = 4)
            else:
                with open(f"assets/{setup.modID}/blockstates/{depluralize(name)}_stairs.json", write) as file:
                    json.dump({"variants": {"facing=east,half=bottom,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs"},"facing=west,half=bottom,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "y": 180,"uvlock": True}, "facing=south,half=bottom,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "y": 90, "uvlock": True},"facing=north,half=bottom,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "y": 270,"uvlock": True}, "facing=east,half=bottom,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer"},"facing=west,half=bottom,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 180,"uvlock": True}, "facing=south,half=bottom,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 90, "uvlock": True},"facing=north,half=bottom,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 270,"uvlock": True}, "facing=east,half=bottom,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 270, "uvlock": True},"facing=west,half=bottom,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 90,"uvlock": True}, "facing=south,half=bottom,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer"},"facing=north,half=bottom,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "y": 180,"uvlock": True}, "facing=east,half=bottom,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner"},"facing=west,half=bottom,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 180,"uvlock": True}, "facing=south,half=bottom,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 90, "uvlock": True},"facing=north,half=bottom,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 270,"uvlock": True}, "facing=east,half=bottom,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 270, "uvlock": True},"facing=west,half=bottom,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 90,"uvlock": True}, "facing=south,half=bottom,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner"},"facing=north,half=bottom,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "y": 180,"uvlock": True}, "facing=east,half=top,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "x": 180, "uvlock": True},"facing=west,half=top,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "x": 180,"y": 180, "uvlock": True}, "facing=south,half=top,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "x": 180, "y": 90, "uvlock": True},"facing=north,half=top,shape=straight": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs", "x": 180,"y": 270, "uvlock": True}, "facing=east,half=top,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 90,"uvlock": True}, "facing=west,half=top,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 270,"uvlock": True}, "facing=south,half=top,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 180,"uvlock": True}, "facing=north,half=top,shape=outer_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "uvlock": True},"facing=east,half=top,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180,"uvlock": True}, "facing=west,half=top,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 180,"uvlock": True}, "facing=south,half=top,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 90,"uvlock": True}, "facing=north,half=top,shape=outer_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_outer", "x": 180, "y": 270,"uvlock": True}, "facing=east,half=top,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 90,"uvlock": True}, "facing=west,half=top,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 270,"uvlock": True}, "facing=south,half=top,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 180,"uvlock": True}, "facing=north,half=top,shape=inner_right": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "uvlock": True},"facing=east,half=top,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180,"uvlock": True}, "facing=west,half=top,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 180,"uvlock": True}, "facing=south,half=top,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 90,"uvlock": True}, "facing=north,half=top,shape=inner_left": {"model": f"{setup.modID}:block/{depluralize(name)}_stairs_inner", "x": 180, "y": 270,"uvlock": True}}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_stairs.json", write) as file:
                    json.dump({"parent": "block/stairs","textures": {"bottom": f"{setup.modID}:block/{name}_planks", "top": f"{setup.modID}:block/{name}_planks","side": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_stairs_inner.json", write) as file:
                    json.dump({"parent": "block/inner_stairs","textures": {"bottom": f"{setup.modID}:block/{name}_planks", "top": f"{setup.modID}:block/{name}_planks","side": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_stairs_outer.json", write) as file:
                    json.dump({"parent": "block/outer_stairs","textures": {"bottom": f"{setup.modID}:block/{name}_planks", "top": f"{setup.modID}:block/{name}_planks","side": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
                with open(f"assets/{setup.modID}/models/item/{depluralize(name)}_stairs.json", write) as file:
                    json.dump({"parent": f"{setup.modID}:block/{depluralize(name)}_stairs"}, file, indent = 4)
        elif(type == "walls"):
            with open(f"assets/{setup.modID}/blockstates/{depluralize(name)}_wall.json", write) as file:
                json.dump({"multipart": [{   "when": { "up": "true" },"apply": { "model": f"{setup.modID}:block/{depluralize(name)}_wall_post" }},{   "when": { "north": "true" },"apply": { "model": f"{setup.modID}:block/{depluralize(name)}_wall_side", "uvlock": True }},{   "when": { "east": "true" },"apply": { "model": f"{setup.modID}:block/{depluralize(name)}_wall_side", "y": 90, "uvlock": True }},{   "when": { "south": "true" },"apply": { "model": f"{setup.modID}:block/{depluralize(name)}_wall_side", "y": 180, "uvlock": True }},{   "when": { "west": "true" },"apply": { "model": f"{setup.modID}:block/{depluralize(name)}_wall_side", "y": 270, "uvlock": True }}]}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_wall_inventory.json", write) as file:
                json.dump({"parent": "block/wall_inventory","textures": {"wall": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_wall_post.json", write) as file:
                json.dump({"parent": "block/template_wall_post","textures": {"wall": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_wall_side.json", write) as file:
                json.dump({"parent": "block/template_wall_side","textures": {"wall": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{depluralize(name)}_wall.json", write) as file:
                json.dump({"parent": f"{setup.modID}:block/{depluralize(name)}_wall_inventory"}, file, indent = 4)
        elif(type == "fences"):
            with open(f"assets/{setup.modID}/blockstates/{depluralize(name)}_fence.json", write) as file:
                json.dump({"multipart": [{   "apply": { "model": f"{setup.modID}:block/{name}_fence_post" }},{   "when": { "north": "true" },"apply": { "model": f"{setup.modID}:block/{name}_fence_side", "uvlock": True }},{   "when": { "east": "true" },"apply": { "model": f"{setup.modID}:block/{name}_fence_side", "y": 90, "uvlock": True }},{   "when": { "south": "true" },"apply": { "model": f"{setup.modID}:block/{name}_fence_side", "y": 180, "uvlock": True }},{   "when": { "west": "true" },"apply": { "model": f"{setup.modID}:block/{name}_fence_side", "y": 270, "uvlock": True }}]}, file, indent = 4)
            with open(f"assets/{setup.modID}/blockstates/{depluralize(name)}_fence_gate.json", write) as file:
                json.dump({"variants": {"facing=south,in_wall=false,open=false": { "model": f"{setup.modID}:block/{name}_fence_gate", "uvlock": True },"facing=west,in_wall=false,open=false":  { "model": f"{setup.modID}:block/{name}_fence_gate", "uvlock": True, "y": 90 },"facing=north,in_wall=false,open=false": { "model": f"{setup.modID}:block/{name}_fence_gate", "uvlock": True, "y": 180 },"facing=east,in_wall=false,open=false":  { "model": f"{setup.modID}:block/{name}_fence_gate", "uvlock": True, "y": 270 },"facing=south,in_wall=false,open=true": { "model": f"{setup.modID}:block/{name}_fence_gate_open", "uvlock": True },"facing=west,in_wall=false,open=true":  { "model": f"{setup.modID}:block/{name}_fence_gate_open", "uvlock": True, "y": 90 },"facing=north,in_wall=false,open=true": { "model": f"{setup.modID}:block/{name}_fence_gate_open", "uvlock": True, "y": 180 },"facing=east,in_wall=false,open=true":  { "model": f"{setup.modID}:block/{name}_fence_gate_open", "uvlock": True, "y": 270 },"facing=south,in_wall=true,open=false": { "model": f"{setup.modID}:block/{name}_fence_gate_wall", "uvlock": True },"facing=west,in_wall=true,open=false":  { "model": f"{setup.modID}:block/{name}_fence_gate_wall", "uvlock": True, "y": 90 },"facing=north,in_wall=true,open=false": { "model": f"{setup.modID}:block/{name}_fence_gate_wall", "uvlock": True, "y": 180 },"facing=east,in_wall=true,open=false":  { "model": f"{setup.modID}:block/{name}_fence_gate_wall", "uvlock": True, "y": 270 },"facing=south,in_wall=true,open=true": { "model": f"{setup.modID}:block/{name}_fence_gate_wall_open", "uvlock": True },"facing=west,in_wall=true,open=true":  { "model": f"{setup.modID}:block/{name}_fence_gate_wall_open", "uvlock": True, "y": 90 },"facing=north,in_wall=true,open=true": { "model": f"{setup.modID}:block/{name}_fence_gate_wall_open", "uvlock": True, "y": 180 },"facing=east,in_wall=true,open=true":  { "model": f"{setup.modID}:block/{name}_fence_gate_wall_open", "uvlock": True, "y": 270 }}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_fence_gate.json", write) as file:
                if(not optionCollectionWood.get()): json.dump({"parent": "block/template_fence_gate","textures": {"texture": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                else:                               json.dump({"parent": "block/template_fence_gate","textures": {"texture": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_fence_gate_open.json", write) as file:
                if(not optionCollectionWood.get()): json.dump({"parent": "block/template_fence_gate_open","textures": {"texture": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                else:                               json.dump({"parent": "block/template_fence_gate_open","textures": {"texture": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_fence_gate_wall.json", write) as file:
                if(not optionCollectionWood.get()): json.dump({"parent": "block/template_fence_gate_wall","textures": {"texture": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                else:                               json.dump({"parent": "block/template_fence_gate_wall","textures": {"texture": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_fence_gate_wall_open.json", write) as file:
                if(not optionCollectionWood.get()): json.dump({"parent": "block/template_fence_gate_wall_open","textures": {"texture": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                else:                               json.dump({"parent": "block/template_fence_gate_wall_open","textures": {"texture": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_fence_inventory.json", write) as file:
                if(not optionCollectionWood.get()): json.dump({"parent": "block/fence_inventory","textures": {"texture": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                else:                               json.dump({"parent": "block/fence_inventory","textures": {"texture": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_fence_post.json", write) as file:
                if(not optionCollectionWood.get()): json.dump({"parent": "block/fence_post","textures": {"texture": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                else:                               json.dump({"parent": "block/fence_post","textures": {"texture": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{depluralize(name)}_fence_side.json", write) as file:
                if(not optionCollectionWood.get()): json.dump({"parent": "block/fence_side","textures": {"texture": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                else:                               json.dump({"parent": "block/fence_side","textures": {"texture": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{depluralize(name)}_fence_gate.json", write) as file:
                json.dump({"parent": f"{setup.modID}:block/{name}_fence_gate"}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{depluralize(name)}_fence.json", write) as file:
                json.dump({"parent": f"{setup.modID}:block/{name}_fence_inventory"}, file, indent = 4)
        elif(type == "panes"):
            with open(f"assets/{setup.modID}/blockstates/{name}_pane.json", write) as file:
                json.dump({"multipart": [{   "apply": { "model": f"{setup.modID}:block/{name}_pane_post" }},{   "when": { "north": True },"apply": { "model": f"{setup.modID}:block/{name}_pane_side" }},{   "when": { "east": True },"apply": { "model": f"{setup.modID}:block/{name}_pane_side", "y": 90 }},{   "when": { "south": True },"apply": { "model": f"{setup.modID}:block/{name}_pane_side_alt" }},{   "when": { "west": True },"apply": { "model": f"{setup.modID}:block/{name}_pane_side_alt", "y": 90 }},{   "when": { "north": False },"apply": { "model": f"{setup.modID}:block/{name}_pane_noside" }},{   "when": { "east": False },"apply": { "model": f"{setup.modID}:block/{name}_pane_noside_alt" }},{   "when": { "south": False },"apply": { "model": f"{setup.modID}:block/{name}_pane_noside_alt", "y": 90 }},{   "when": { "west": False },"apply": { "model": f"{setup.modID}:block/{name}_pane_noside", "y": 270 }}]}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}_pane_noside.json", write) as file:
                json.dump({"parent": "block/template_glass_pane_noside","textures": {"pane": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}_pane_noside_alt.json", write) as file:
                json.dump({"parent": "block/template_glass_pane_noside_alt","textures": {"pane": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}_pane_post.json", write) as file:
                json.dump({"parent": "block/template_glass_pane_post","textures": {"edge": f"{setup.modID}:block/{name}_pane_top","pane": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}_pane_side.json", write) as file:
                json.dump({"parent": "block/template_glass_pane_side","textures": {"edge": f"{setup.modID}:block/{name}_pane_top","pane": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}_pane_side_alt.json", write) as file:
                json.dump({"parent": "block/template_glass_pane_side_alt","textures": {"edge": f"{setup.modID}:block/{name}_pane_top","pane": f"{setup.modID}:block/{name}"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{name}_pane.json", write) as file:
                json.dump({"parent": "item/generated","textures": {"layer0": f"{setup.modID}:item/{name}"}}, file, indent = 4)
        elif(type == "buttons"):
            with open(f"assets/{setup.modID}/blockstates/{name}_button.json", write) as file:
                json.dump({"variants": {"face=floor,facing=east,powered=false":  { "model": f"{setup.modID}:block/{name}_button", "y": 90 },"face=floor,facing=west,powered=false":  { "model": f"{setup.modID}:block/{name}_button", "y": 270 },"face=floor,facing=south,powered=false": { "model": f"{setup.modID}:block/{name}_button", "y": 180 },"face=floor,facing=north,powered=false": { "model": f"{setup.modID}:block/{name}_button" },"face=wall,facing=east,powered=false":  { "model": f"{setup.modID}:block/{name}_button", "uvlock": True, "x": 90, "y": 90 },"face=wall,facing=west,powered=false":  { "model": f"{setup.modID}:block/{name}_button", "uvlock": True, "x": 90, "y": 270 },"face=wall,facing=south,powered=false": { "model": f"{setup.modID}:block/{name}_button", "uvlock": True, "x": 90, "y": 180 },"face=wall,facing=north,powered=false": { "model": f"{setup.modID}:block/{name}_button", "uvlock": True, "x": 90 },"face=ceiling,facing=east,powered=false":  { "model": f"{setup.modID}:block/{name}_button", "x": 180, "y": 270 },"face=ceiling,facing=west,powered=false":  { "model": f"{setup.modID}:block/{name}_button", "x": 180, "y": 90 },"face=ceiling,facing=south,powered=false": { "model": f"{setup.modID}:block/{name}_button", "x": 180 },"face=ceiling,facing=north,powered=false": { "model": f"{setup.modID}:block/{name}_button", "x": 180, "y": 180 },"face=floor,facing=east,powered=true":  { "model": f"{setup.modID}:block/{name}_button_pressed", "y": 90 },"face=floor,facing=west,powered=true":  { "model": f"{setup.modID}:block/{name}_button_pressed", "y": 270 },"face=floor,facing=south,powered=true": { "model": f"{setup.modID}:block/{name}_button_pressed", "y": 180 },"face=floor,facing=north,powered=true": { "model": f"{setup.modID}:block/{name}_button_pressed" },"face=wall,facing=east,powered=true":  { "model": f"{setup.modID}:block/{name}_button_pressed", "uvlock": True, "x": 90, "y": 90 },"face=wall,facing=west,powered=true":  { "model": f"{setup.modID}:block/{name}_button_pressed", "uvlock": True, "x": 90, "y": 270 },"face=wall,facing=south,powered=true": { "model": f"{setup.modID}:block/{name}_button_pressed", "uvlock": True, "x": 90, "y": 180 },"face=wall,facing=north,powered=true": { "model": f"{setup.modID}:block/{name}_button_pressed", "uvlock": True, "x": 90 },"face=ceiling,facing=east,powered=true":  { "model": f"{setup.modID}:block/{name}_button_pressed", "x": 180, "y": 270 },"face=ceiling,facing=west,powered=true":  { "model": f"{setup.modID}:block/{name}_button_pressed", "x": 180, "y": 90 },"face=ceiling,facing=south,powered=true": { "model": f"{setup.modID}:block/{name}_button_pressed", "x": 180 },"face=ceiling,facing=north,powered=true": { "model": f"{setup.modID}:block/{name}_button_pressed", "x": 180, "y": 180 }}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}_button.json", write) as file:
                if (not optionCollectionWood.get()): json.dump({"parent": "block/button","textures": {"texture": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                else:                                json.dump({"parent": "block/button","textures": {"texture": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}_button_pressed.json", write) as file:
                if (not optionCollectionWood.get()): json.dump({"parent": "block/button_pressed","textures": {"texture": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                else:                                json.dump({"parent": "block/button_pressed","textures": {"texture": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/block/{name}_button_inventory.json", write) as file:
                if (not optionCollectionWood.get()): json.dump({"parent": "block/button_inventory","textures": {"texture": f"{setup.modID}:block/{name}"}}, file, indent = 4)
                else:                                json.dump({"parent": "block/button_inventory","textures": {"texture": f"{setup.modID}:block/{name}_planks"}}, file, indent = 4)
            with open(f"assets/{setup.modID}/models/item/{name}_button.json", write) as file:
                json.dump({"parent": f"{setup.modID}:block/{name}_button_inventory"}, file, indent = 4)
        elif(type == "plates"):
            pass
        elif(type == "doors"):
            pass
    except FileExistsError:
        messagebox.showwarning(title = "File Overwrite", message = "This would overwrite an existing file\nEither delete the existing files or change the overwrite option in DefaultConfig.py")
        exit()


def runGenerator(name):
    if(optionCollectionWood.get() or optionCollectionStone.get() or optionCollectionStonePlus.get() or optionCollectionGlass.get() or optionCollectionColour.get()):
        if(optionCollectionWood.get()):
            createFiles("cube", f"{name}_planks")
            createFiles("cube", f"{name}_leaves")
            createFiles("cube", f"{name}_wood")
            createFiles("cube", f"stripped_{name}_wood")
            createFiles("rotatable_three", f"{name}_log")
            createFiles("rotatable_three", f"stripped_{name}_log")
            createFiles("cross", f"{name}_sapling")
            createFiles("slabs", name)
            createFiles("stairs", name)
            createFiles("fences", name)
            createFiles("buttons", name)
            createFiles("plates", name)
            createFiles("doors", name)
        if(optionCollectionStone.get()):
            pass
        if(optionCollectionStonePlus.get()):
            pass
        if(optionCollectionStonePlus.get()):
            pass
        if(optionCollectionGlass.get()):
            createFiles("cube", "glass")
            createFiles("panes", "glass")
            for i in range(0, 16):
                createFiles("cube", colours[i]+"_stained_glass")
                createFiles("panes", colours[i]+"_stained_glass")
        if(optionCollectionColour.get()):
            for i in range(0, 16):
                createFiles("cube", colours[i] + f"_{name}")
    else:
        if(optionBlock.get()):  createFiles(optionBlockstate.get(), name)
        if(optionSlabs.get()):  createFiles("slabs", name)
        if(optionStairs.get()): createFiles("stairs", name)
        if(optionWalls.get()):  createFiles("walls", name)
        if(optionFences.get()):  createFiles("fences", name)
        if(optionButtons.get()):  createFiles("buttons", name)
        if(optionPlates.get()):  createFiles("plates", name)
        if(optionDoors.get()):  createFiles("doors", name)



def runConfirmation():
    name = formatString(blockName)
    if(not optionCollectionGlass.get() and name == ""):
        messagebox.showwarning(title = "Warning: Null Name", message = "Please enter a name for your block.")
    elif(messagebox.askokcancel(title = "Run Confirmation", message = f"Do you want to run the generator?\nBase Name: \"{name}\"")):
        runGenerator(name)


def main():
    notebook = ttk.Notebook(window)
    tab1 = ttk.Frame(notebook)
    tab2 = ttk.Frame(notebook)
    notebook.add(tab1, text = 'Assets')
    notebook.add(tab2, text = 'Data')
    notebook.pack(fill = BOTH)

    sep11 = ttk.Separator(tab1).grid(row = 0, columnspan = 2, sticky = "WE", padx = 10, pady = 10)

    insert = ttk.Label(tab1, text = "Insert Block Name:").grid(row = 1, column = 0, padx = 20)
    entry = ttk.Entry(tab1, textvariable = blockName, width = 16).grid(row = 1, column = 1, padx = 20)

    sep12 = ttk.Separator(tab1).grid(row = 2, columnspan = 2, sticky = "WE", padx = 10, pady = 10)

    menuBlockstate = ttk.Menubutton(tab1, textvariable = menuText, width = 23)
    menuBlockstate.menu = Menu(menuBlockstate)
    menuBlockstate["menu"] = menuBlockstate.menu
    menuBlockstate.menu.add_radiobutton(label = "Not Rotatable - Cube", variable = optionBlockstate, value = "cube", command = updateRadio)
    menuBlockstate.menu.add_radiobutton(label = "Not Rotatable - Cube Column", variable = optionBlockstate, value = "cube_column", command = updateRadio)
    menuBlockstate.menu.add_radiobutton(label = "Not Rotatable - Cube Bottom Top", variable = optionBlockstate, value = "cube_bottom_top", command = updateRadio)
    menuBlockstate.menu.add_radiobutton(label = "Not Rotatable - Orientable", variable = optionBlockstate, value = "orientable", command = updateRadio)
    menuBlockstate.menu.add_radiobutton(label = "Three Way Rotatable (Axis)", variable = optionBlockstate, value = "rotatable_three", command = updateRadio)
    menuBlockstate.menu.add_radiobutton(label = "Four Way Rotatable (Horizontal)", variable = optionBlockstate, value = "rotatable_four", command = updateRadio)
    menuBlockstate.menu.add_radiobutton(label = "Six Way Rotatable", variable = optionBlockstate, value = "rotatable_six", command = updateRadio)
    menuBlockstate.menu.add_radiobutton(label = "Cross Model", variable = optionBlockstate, value = "cross", command = updateRadio)
    menuBlockstate.menu.add_separator()
    menuBlockstate.menu.add_radiobutton(label = "No Block - 2D Item Only", variable = optionBlockstate, value = "item", command = updateRadio)
    menuBlockstate.grid(row = 3, columnspan = 2, sticky = "E", padx = 20)
    checkBlock = ttk.Checkbutton(tab1, text = "Block", variable = optionBlock).grid(row = 3, sticky = "W", padx = 20)

    sep13 = ttk.Separator(tab1).grid(row = 4, columnspan = 2, sticky = "WE", padx = 10, pady = 10)

    checkSlabs = ttk.Checkbutton(tab1, text = "Slabs", variable = optionSlabs).grid(row = 5, sticky = "W", padx = 20)
    checkStairs = ttk.Checkbutton(tab1, text = "Stairs", variable = optionStairs).grid(row = 6, sticky = "W", padx = 20)
    checkWalls = ttk.Checkbutton(tab1, text = "Walls", variable = optionWalls).grid(row = 7, sticky = "W", padx = 20)
    checkFences = ttk.Checkbutton(tab1, text = "Fences", variable = optionFences).grid(row = 8, sticky = "W", padx = 20)
    checkPanes = ttk.Checkbutton(tab1, text = "Panes", variable = optionPanes).grid(row = 9, sticky = "W", padx = 20)
    checkButtons = ttk.Checkbutton(tab1, text = "Buttons", variable = optionButtons).grid(row = 10, sticky = "W", padx = 20)
    checkPlates = ttk.Checkbutton(tab1, text = "Pressure Plates", variable = optionPlates, state = DISABLED).grid(row = 11, columnspan = 2, sticky = "W", padx = 20)
    checkDoors = ttk.Checkbutton(tab1, text = "Doors & Trapdoors", variable = optionDoors, state = DISABLED).grid(row = 12, columnspan = 2, sticky = "W", padx = 20)

    sep14 = ttk.Separator(tab1).grid(row = 13, columnspan = 2, sticky = "WE", padx = 10, pady = 10)

    checkCollectionWood = ttk.Checkbutton(tab1, text = "Wood Collection", variable = optionCollectionWood).grid(row = 14, columnspan = 2, sticky = "W", padx = 20)
    checkCollectionStone = ttk.Checkbutton(tab1, text = "Stone Collection", variable = optionCollectionStone, state = DISABLED).grid(row = 15, columnspan = 2, sticky = "W", padx = 20)
    checkCollectionStonePlus = ttk.Checkbutton(tab1, text = "Stone Collection+", variable = optionCollectionStonePlus, state = DISABLED).grid(row = 16, columnspan = 2, sticky = "W", padx = 20)
    #checkCollectionGlass = ttk.Checkbutton(tab1, text = "Glass Collection", variable = optionCollectionGlass).grid(row = 17, columnspan = 2, sticky = "W", padx = 20)
    checkCollectionColour = ttk.Checkbutton(tab1, text = "Colourful Collection", variable = optionCollectionColour).grid(row = 18, columnspan = 2, sticky = "W", padx = 20)

    sep15 = ttk.Separator(tab1).grid(row = 19, columnspan = 2, sticky = "WE", padx = 10, pady = 10)

    quit = ttk.Button(tab1, text = "Quit", command = exit).grid(row = 20, column = 0, sticky = "W", padx = 20)
    run = ttk.Button(tab1, text = "Run", command = runConfirmation).grid(row = 20, column = 1, sticky = "E", padx = 20)

    sep16 = ttk.Separator(tab1).grid(row = 21, columnspan = 2, sticky = "WE", padx = 10, pady = 10)


main()
window.mainloop()
