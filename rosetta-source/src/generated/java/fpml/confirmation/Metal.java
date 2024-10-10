package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.CommodityMetalBrand;
import fpml.confirmation.CommodityMetalGrade;
import fpml.confirmation.CommodityMetalShape;
import fpml.confirmation.Material;
import fpml.confirmation.Metal;
import fpml.confirmation.Metal.MetalBuilder;
import fpml.confirmation.Metal.MetalBuilderImpl;
import fpml.confirmation.Metal.MetalImpl;
import fpml.confirmation.meta.MetalMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining the characteristics of the metal product being traded in a physically settled metal transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="Metal", builder=Metal.MetalBuilderImpl.class, version="${project.version}")
public interface Metal extends RosettaModelObject {

	MetalMeta metaData = new MetalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The types of metal product for a physically settled metal trade.
	 */
	Material getMaterial();
	/**
	 * The physical shape(s) which can be delivered in Seller&#39;s option.
	 */
	List<? extends CommodityMetalShape> getShape();
	/**
	 * The brand(s) of material which can be delivered in Seller&#39;s option.
	 */
	List<? extends CommodityMetalBrand> getBrand();
	/**
	 * The grade(s) of material which can be delivered in seller&#39;s option.
	 */
	List<? extends CommodityMetalGrade> getGrade();

	/*********************** Build Methods  ***********************/
	Metal build();
	
	Metal.MetalBuilder toBuilder();
	
	static Metal.MetalBuilder builder() {
		return new Metal.MetalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Metal> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Metal> getType() {
		return Metal.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("material"), processor, Material.class, getMaterial());
		processRosetta(path.newSubPath("shape"), processor, CommodityMetalShape.class, getShape());
		processRosetta(path.newSubPath("brand"), processor, CommodityMetalBrand.class, getBrand());
		processRosetta(path.newSubPath("grade"), processor, CommodityMetalGrade.class, getGrade());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MetalBuilder extends Metal, RosettaModelObjectBuilder {
		Material.MaterialBuilder getOrCreateMaterial();
		Material.MaterialBuilder getMaterial();
		CommodityMetalShape.CommodityMetalShapeBuilder getOrCreateShape(int _index);
		List<? extends CommodityMetalShape.CommodityMetalShapeBuilder> getShape();
		CommodityMetalBrand.CommodityMetalBrandBuilder getOrCreateBrand(int _index);
		List<? extends CommodityMetalBrand.CommodityMetalBrandBuilder> getBrand();
		CommodityMetalGrade.CommodityMetalGradeBuilder getOrCreateGrade(int _index);
		List<? extends CommodityMetalGrade.CommodityMetalGradeBuilder> getGrade();
		Metal.MetalBuilder setMaterial(Material material);
		Metal.MetalBuilder addShape(CommodityMetalShape shape0);
		Metal.MetalBuilder addShape(CommodityMetalShape shape1, int _idx);
		Metal.MetalBuilder addShape(List<? extends CommodityMetalShape> shape2);
		Metal.MetalBuilder setShape(List<? extends CommodityMetalShape> shape3);
		Metal.MetalBuilder addBrand(CommodityMetalBrand brand0);
		Metal.MetalBuilder addBrand(CommodityMetalBrand brand1, int _idx);
		Metal.MetalBuilder addBrand(List<? extends CommodityMetalBrand> brand2);
		Metal.MetalBuilder setBrand(List<? extends CommodityMetalBrand> brand3);
		Metal.MetalBuilder addGrade(CommodityMetalGrade grade0);
		Metal.MetalBuilder addGrade(CommodityMetalGrade grade1, int _idx);
		Metal.MetalBuilder addGrade(List<? extends CommodityMetalGrade> grade2);
		Metal.MetalBuilder setGrade(List<? extends CommodityMetalGrade> grade3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("material"), processor, Material.MaterialBuilder.class, getMaterial());
			processRosetta(path.newSubPath("shape"), processor, CommodityMetalShape.CommodityMetalShapeBuilder.class, getShape());
			processRosetta(path.newSubPath("brand"), processor, CommodityMetalBrand.CommodityMetalBrandBuilder.class, getBrand());
			processRosetta(path.newSubPath("grade"), processor, CommodityMetalGrade.CommodityMetalGradeBuilder.class, getGrade());
		}
		

		Metal.MetalBuilder prune();
	}

	/*********************** Immutable Implementation of Metal  ***********************/
	class MetalImpl implements Metal {
		private final Material material;
		private final List<? extends CommodityMetalShape> shape;
		private final List<? extends CommodityMetalBrand> brand;
		private final List<? extends CommodityMetalGrade> grade;
		
		protected MetalImpl(Metal.MetalBuilder builder) {
			this.material = ofNullable(builder.getMaterial()).map(f->f.build()).orElse(null);
			this.shape = ofNullable(builder.getShape()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.brand = ofNullable(builder.getBrand()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.grade = ofNullable(builder.getGrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("material")
		public Material getMaterial() {
			return material;
		}
		
		@Override
		@RosettaAttribute("shape")
		public List<? extends CommodityMetalShape> getShape() {
			return shape;
		}
		
		@Override
		@RosettaAttribute("brand")
		public List<? extends CommodityMetalBrand> getBrand() {
			return brand;
		}
		
		@Override
		@RosettaAttribute("grade")
		public List<? extends CommodityMetalGrade> getGrade() {
			return grade;
		}
		
		@Override
		public Metal build() {
			return this;
		}
		
		@Override
		public Metal.MetalBuilder toBuilder() {
			Metal.MetalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Metal.MetalBuilder builder) {
			ofNullable(getMaterial()).ifPresent(builder::setMaterial);
			ofNullable(getShape()).ifPresent(builder::setShape);
			ofNullable(getBrand()).ifPresent(builder::setBrand);
			ofNullable(getGrade()).ifPresent(builder::setGrade);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Metal _that = getType().cast(o);
		
			if (!Objects.equals(material, _that.getMaterial())) return false;
			if (!ListEquals.listEquals(shape, _that.getShape())) return false;
			if (!ListEquals.listEquals(brand, _that.getBrand())) return false;
			if (!ListEquals.listEquals(grade, _that.getGrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (material != null ? material.hashCode() : 0);
			_result = 31 * _result + (shape != null ? shape.hashCode() : 0);
			_result = 31 * _result + (brand != null ? brand.hashCode() : 0);
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Metal {" +
				"material=" + this.material + ", " +
				"shape=" + this.shape + ", " +
				"brand=" + this.brand + ", " +
				"grade=" + this.grade +
			'}';
		}
	}

	/*********************** Builder Implementation of Metal  ***********************/
	class MetalBuilderImpl implements Metal.MetalBuilder {
	
		protected Material.MaterialBuilder material;
		protected List<CommodityMetalShape.CommodityMetalShapeBuilder> shape = new ArrayList<>();
		protected List<CommodityMetalBrand.CommodityMetalBrandBuilder> brand = new ArrayList<>();
		protected List<CommodityMetalGrade.CommodityMetalGradeBuilder> grade = new ArrayList<>();
	
		public MetalBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("material")
		public Material.MaterialBuilder getMaterial() {
			return material;
		}
		
		@Override
		public Material.MaterialBuilder getOrCreateMaterial() {
			Material.MaterialBuilder result;
			if (material!=null) {
				result = material;
			}
			else {
				result = material = Material.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("shape")
		public List<? extends CommodityMetalShape.CommodityMetalShapeBuilder> getShape() {
			return shape;
		}
		
		public CommodityMetalShape.CommodityMetalShapeBuilder getOrCreateShape(int _index) {
		
			if (shape==null) {
				this.shape = new ArrayList<>();
			}
			CommodityMetalShape.CommodityMetalShapeBuilder result;
			return getIndex(shape, _index, () -> {
						CommodityMetalShape.CommodityMetalShapeBuilder newShape = CommodityMetalShape.builder();
						return newShape;
					});
		}
		
		@Override
		@RosettaAttribute("brand")
		public List<? extends CommodityMetalBrand.CommodityMetalBrandBuilder> getBrand() {
			return brand;
		}
		
		public CommodityMetalBrand.CommodityMetalBrandBuilder getOrCreateBrand(int _index) {
		
			if (brand==null) {
				this.brand = new ArrayList<>();
			}
			CommodityMetalBrand.CommodityMetalBrandBuilder result;
			return getIndex(brand, _index, () -> {
						CommodityMetalBrand.CommodityMetalBrandBuilder newBrand = CommodityMetalBrand.builder();
						return newBrand;
					});
		}
		
		@Override
		@RosettaAttribute("grade")
		public List<? extends CommodityMetalGrade.CommodityMetalGradeBuilder> getGrade() {
			return grade;
		}
		
		public CommodityMetalGrade.CommodityMetalGradeBuilder getOrCreateGrade(int _index) {
		
			if (grade==null) {
				this.grade = new ArrayList<>();
			}
			CommodityMetalGrade.CommodityMetalGradeBuilder result;
			return getIndex(grade, _index, () -> {
						CommodityMetalGrade.CommodityMetalGradeBuilder newGrade = CommodityMetalGrade.builder();
						return newGrade;
					});
		}
		
		@Override
		@RosettaAttribute("material")
		public Metal.MetalBuilder setMaterial(Material material) {
			this.material = material==null?null:material.toBuilder();
			return this;
		}
		@Override
		public Metal.MetalBuilder addShape(CommodityMetalShape shape) {
			if (shape!=null) this.shape.add(shape.toBuilder());
			return this;
		}
		
		@Override
		public Metal.MetalBuilder addShape(CommodityMetalShape shape, int _idx) {
			getIndex(this.shape, _idx, () -> shape.toBuilder());
			return this;
		}
		@Override 
		public Metal.MetalBuilder addShape(List<? extends CommodityMetalShape> shapes) {
			if (shapes != null) {
				for (CommodityMetalShape toAdd : shapes) {
					this.shape.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("shape")
		public Metal.MetalBuilder setShape(List<? extends CommodityMetalShape> shapes) {
			if (shapes == null)  {
				this.shape = new ArrayList<>();
			}
			else {
				this.shape = shapes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Metal.MetalBuilder addBrand(CommodityMetalBrand brand) {
			if (brand!=null) this.brand.add(brand.toBuilder());
			return this;
		}
		
		@Override
		public Metal.MetalBuilder addBrand(CommodityMetalBrand brand, int _idx) {
			getIndex(this.brand, _idx, () -> brand.toBuilder());
			return this;
		}
		@Override 
		public Metal.MetalBuilder addBrand(List<? extends CommodityMetalBrand> brands) {
			if (brands != null) {
				for (CommodityMetalBrand toAdd : brands) {
					this.brand.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("brand")
		public Metal.MetalBuilder setBrand(List<? extends CommodityMetalBrand> brands) {
			if (brands == null)  {
				this.brand = new ArrayList<>();
			}
			else {
				this.brand = brands.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Metal.MetalBuilder addGrade(CommodityMetalGrade grade) {
			if (grade!=null) this.grade.add(grade.toBuilder());
			return this;
		}
		
		@Override
		public Metal.MetalBuilder addGrade(CommodityMetalGrade grade, int _idx) {
			getIndex(this.grade, _idx, () -> grade.toBuilder());
			return this;
		}
		@Override 
		public Metal.MetalBuilder addGrade(List<? extends CommodityMetalGrade> grades) {
			if (grades != null) {
				for (CommodityMetalGrade toAdd : grades) {
					this.grade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("grade")
		public Metal.MetalBuilder setGrade(List<? extends CommodityMetalGrade> grades) {
			if (grades == null)  {
				this.grade = new ArrayList<>();
			}
			else {
				this.grade = grades.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Metal build() {
			return new Metal.MetalImpl(this);
		}
		
		@Override
		public Metal.MetalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Metal.MetalBuilder prune() {
			if (material!=null && !material.prune().hasData()) material = null;
			shape = shape.stream().filter(b->b!=null).<CommodityMetalShape.CommodityMetalShapeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			brand = brand.stream().filter(b->b!=null).<CommodityMetalBrand.CommodityMetalBrandBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			grade = grade.stream().filter(b->b!=null).<CommodityMetalGrade.CommodityMetalGradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMaterial()!=null && getMaterial().hasData()) return true;
			if (getShape()!=null && getShape().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBrand()!=null && getBrand().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getGrade()!=null && getGrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Metal.MetalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Metal.MetalBuilder o = (Metal.MetalBuilder) other;
			
			merger.mergeRosetta(getMaterial(), o.getMaterial(), this::setMaterial);
			merger.mergeRosetta(getShape(), o.getShape(), this::getOrCreateShape);
			merger.mergeRosetta(getBrand(), o.getBrand(), this::getOrCreateBrand);
			merger.mergeRosetta(getGrade(), o.getGrade(), this::getOrCreateGrade);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Metal _that = getType().cast(o);
		
			if (!Objects.equals(material, _that.getMaterial())) return false;
			if (!ListEquals.listEquals(shape, _that.getShape())) return false;
			if (!ListEquals.listEquals(brand, _that.getBrand())) return false;
			if (!ListEquals.listEquals(grade, _that.getGrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (material != null ? material.hashCode() : 0);
			_result = 31 * _result + (shape != null ? shape.hashCode() : 0);
			_result = 31 * _result + (brand != null ? brand.hashCode() : 0);
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetalBuilder {" +
				"material=" + this.material + ", " +
				"shape=" + this.shape + ", " +
				"brand=" + this.brand + ", " +
				"grade=" + this.grade +
			'}';
		}
	}
}
