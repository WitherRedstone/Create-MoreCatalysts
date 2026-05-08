# 机械动力：更多触媒(Create: More Catalysts) 功能分类文档

[English](#english) | [中文](#中文)

---

# **English**

## Introduction

Adds multiple catalyst types to Create mod's Encased Fan, expanding processing possibilities.

## Features

### Batch Withering
- **Catalyst**: Wither Rose
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List:
    - Skeleton -> Wither Skeleton
  - Entity Healing List & Amount:
    - Wither +10 HP
    - Wither Skeleton +2 HP
  - Entity Status Effects List:
    - Wither I for 5 seconds

### Batch Snow Flow
- **Catalyst**: Snow Block
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List:
    - Skeleton -> Stray
    - Villager -> Snow Golem
  - Entity Healing List & Amount:
    - Stray +2 HP
    - Snow Golem +4 HP
  - Entity Status Effects List:
    - Slowness I for 6 seconds
- **Special Effect**:
  - Puts entities in powder snow freezing state

### Batch Purifying
- **Catalyst**: Beacon
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List:
    - Zombie Villager -> Villager
    - Vex -> Allay
    - Hoglin -> Pig
    - Ravager -> Cow
    - Elder Guardian -> Guardian
    - Vindicator -> Villager
    - Phantom -> Bat
    - Zombie Horse -> Horse
    - Endermite -> Silverfish
  - Entity Healing List & Amount:
    - Villager +2 HP
  - Entity Status Effects List:
    - Regeneration I for 6 seconds

### Batch Sculking
- **Catalyst**: Sculk Catalyst
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List:
    - Iron Golem -> Warden
  - Entity Healing List & Amount:
    - Warden +10 HP
  - Entity Status Effects List:
    - Darkness I for 6 seconds
    - Blindness I for 6 seconds

### Batch Resonance
- **Catalyst**: Amethyst Cluster
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None

### Batch Sand Blow
- **Catalyst**: Sand
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List:
    - Zombie -> Husk
  - Entity Healing List & Amount:
    - Husk +2 HP
  - Entity Status Effects List:
    - Slowness I for 6 seconds

### Batch Breathed Wind
- **Catalyst**: Dragon Head
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None

### Batch Exploding
- **Catalyst**: Creeper Head
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None
- **Special Effect**:
  - Creates explosion on entities

### Batch Tidal
- **Catalyst**: Conduit
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List:
    - Conduit Power I for 6 seconds

### Batch Tear
- **Catalyst**: Crying Obsidian
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List:
    - Phantom -> Ghast
  - Entity Healing List & Amount: None
  - Entity Status Effects List:
    - Blindness I for 6 seconds

### Batch Mossify
- **Catalyst**: Moss Block
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List:
    - Skeleton -> Bogged
  - Entity Healing List & Amount:
    - Bogged +2 HP
  - Entity Status Effects List: None

### Batch Honey Coating
- **Catalyst**: Honey Fluid
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None

### Batch Chocolate Coating
- **Catalyst**: Chocolate Fluid
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None


## Mod Integration

### **Mekanism**

### Batch Salout
- **Catalyst**: Brine
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None

### Batch Etch
- **Catalyst**: Liquid Hydrofluoric Acid
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None

### Batch Sulfon
- **Catalyst**: Liquid Sulfur Dioxide
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None

### Batch Dehyd
- **Catalyst**: Liquid Sulfuric Acid
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None

### Batch Oxidize
- **Catalyst**: Liquid Oxygen
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None

### Batch Reduce
- **Catalyst**: Liquid Hydrogen
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None

### Batch Ferment
- **Catalyst**: Bioethanol
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None


### **Immersive Engineering**

### Batch Preservation
- **Catalyst**: Creosote Oil
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List: None
  - Entity Healing List & Amount: None
  - Entity Status Effects List: None


### **Anvilcraft/L2Hostility**

### Batch Corrupted
- **Catalyst**: Corrupted Beacon/Hostility Beacon
- **Configurable**:
  - Enable: Default ON
  - Entity Transformation List:
    - Pig -> Hoglin
    - Cow -> Ravager
    - Guardian -> Elder Guardian
    - Villager -> Vindicator
    - Llama -> Vex
    - Bat -> Phantom
    - Horse -> Zombie Horse
    - Silverfish -> Endermite
  - Entity Healing List & Amount: None
  - Entity Status Effects List:
    - Wither II for 6 seconds


## Configuration

All fan types can be independently enabled/disabled in `config/create-more-catalysts-common.toml`.

---

# **中文**

## 简介

为 Create 模组的鼓风机添加多种触媒类型，扩展加工可能性。

## 功能特性

### 批量凋零 (Withering)
- **触媒**：凋灵玫瑰
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：
    - 骷髅->凋零骷髅
  - 实体治疗列表及治疗量：
    - 凋灵+10点生命
    - 凋零骷髅+2点生命
  - 实体状态效果列表：
    - 1级凋零5秒

### 批量雪流 (Snow Flow)
- **触媒**：雪块
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：
    - 骷髅->流浪者
    - 村民->雪傀儡
  - 实体治疗列表及治疗量：
    - 流浪者+2点生命、
    - 雪傀儡+4点生命
  - 实体状态效果列表：
    - 1级缓慢6秒
- **特殊效果**：
  - 使实体进入细雪冻结状态

### 批量净化 (Purifying)
- **触媒**：信标
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：
    - 僵尸村民->村民
    - 恼鬼->悦灵
    - 疣猪兽->猪
    - 劫掠兽->牛
    - 远古守卫者->守卫者
    - 卫道士->村民
    - 幻翼->蝙蝠
    - 僵尸马->马
    - 末影螨->蠹虫
  - 实体治疗列表及治疗量：
    - 村民+2点生命
  - 实体状态效果列表：
    - 1级再生6秒

### 批量幽匿 (Sculking)
- **触媒**：幽匿催发体
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：
    - 铁傀儡->监守者
  - 实体治疗列表及治疗量：
    - 监守者+10点生命
  - 实体状态效果列表：
    - 1级黑暗6秒
    - 1级失明6秒

### 批量共振 (Resonance)
- **触媒**：紫水晶簇
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无

### 批量扬砂 (Sand Blow)
- **触媒**：沙子
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：
    - 僵尸->尸壳
  - 实体治疗列表及治疗量：
    - 尸壳+2点生命
  - 实体状态效果列表：
    - 1级缓慢6秒

### 批量吐息 (Breathed Wind)
- **触媒**：龙首
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无

### 批量爆炸 (Exploding)
- **触媒**：苦力怕头颅
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无
- **特殊效果**：
  - 对生物产生爆炸

### 批量海潮 (Tidal)
- **触媒**：潮涌核心
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：
    - 1级潮涌能量6秒

### 批量催泪 (Tear)
- **触媒**：哭泣的黑曜石
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：
    - 幻翼->恶魂
  - 实体治疗列表及治疗量：
  - 实体状态效果列表：
    - 1级失明6秒

### 批量苔化 (Mossify)
- **触媒**：苔藓块
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：
    - 骷髅->沼骸
  - 实体治疗列表及治疗量：
    - 沼骸+2点生命
  - 实体状态效果列表：无

### 批量裹蜜 (Honey Coating)
- **触媒**：蜂蜜流体
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无

### 批量凝巧 (Chocolate Coating)
- **触媒**：巧克力流体
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无


## 模组联动

### **通用机械**

### 批量盐析 (Salout)
- **触媒**：盐水
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无

### 批量蚀刻 (Etch)
- **触媒**：液态氢氟酸
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无

### 批量磺化 (Sulfon)
- **触媒**：液态二氧化硫
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无

### 批量脱水 (Dehyd)
- **触媒**：液态硫酸
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无

### 批量氧化 (Oxidize)
- **触媒**：液态氧
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无

### 批量还原 (Reduce)
- **触媒**：液态氢
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无

### 批量发酵 (Ferment)
- **触媒**：生物乙醇
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无


### **沉浸工程**

### 批量防腐 (Preservation)
- **触媒**：杂酚油
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：无
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：无


### **铁砧工艺/莱特兰-恶意**

### 批量腐化 (Corrupted)
- **触媒**：腐化信标/恶意信标
- **可配置**：
  - 是否启用：默认开
  - 实体转换列表：
    - 猪->疣猪兽
    - 牛->劫掠兽
    - 守卫者->远古守卫者
    - 村民->卫道士
    - 羊驼->恼鬼
    - 蝙蝠->幻翼
    - 马->僵尸马
    - 蠹虫->末影螨
  - 实体治疗列表及治疗量：无
  - 实体状态效果列表：
    - 2级凋零6秒


## 配置

所有鼓风机类型均可在 `config/create-more-catalysts-common.toml` 中独立启用/禁用。