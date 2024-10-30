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
import fpml.confirmation.CoalProduct;
import fpml.confirmation.CoalProduct.CoalProductBuilder;
import fpml.confirmation.CoalProduct.CoalProductBuilderImpl;
import fpml.confirmation.CoalProduct.CoalProductImpl;
import fpml.confirmation.CoalProductSource;
import fpml.confirmation.CoalProductSpecifications;
import fpml.confirmation.CoalProductType;
import fpml.confirmation.CommodityUSCoalProductModel;
import fpml.confirmation.meta.CoalProductMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining the characteristics of the coal being traded in a physically settled gas transaction.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CoalProduct", builder=CoalProduct.CoalProductBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CoalProduct extends RosettaModelObject {

	CoalProductMeta metaData = new CoalProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of coal product to be delivered by reference to a pre-defined specification. For contracts under SCoTA terms this is the quality specification code (e.g. &quot;DES ARA&quot;)
	 */
	CoalProductType get_type();
	/**
	 * The type of coal product to be delivered specified in full.
	 */
	CoalProductSpecifications getCoalProductSpecifications();
	/**
	 * The SCoTA cargo origin, mining region, mine(s), mining complex(es), loadout(s) or river dock(s) or other point(s) of origin that Seller and Buyer agree are acceptable origins for the Coal Product. For International Coal transactions, this is the Origin of the Coal Product.
	 */
	List<? extends CoalProductSource> getSource();
	/**
	 * Indicates whether type and source refer to globalCOAL SCoTA specifications.
	 */
	Boolean getSCoTASpecifications();
	CommodityUSCoalProductModel getCommodityUSCoalProductModel();

	/*********************** Build Methods  ***********************/
	CoalProduct build();
	
	CoalProduct.CoalProductBuilder toBuilder();
	
	static CoalProduct.CoalProductBuilder builder() {
		return new CoalProduct.CoalProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalProduct> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CoalProduct> getType() {
		return CoalProduct.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("_type"), processor, CoalProductType.class, get_type());
		processRosetta(path.newSubPath("coalProductSpecifications"), processor, CoalProductSpecifications.class, getCoalProductSpecifications());
		processRosetta(path.newSubPath("source"), processor, CoalProductSource.class, getSource());
		processor.processBasic(path.newSubPath("sCoTASpecifications"), Boolean.class, getSCoTASpecifications(), this);
		processRosetta(path.newSubPath("commodityUSCoalProductModel"), processor, CommodityUSCoalProductModel.class, getCommodityUSCoalProductModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalProductBuilder extends CoalProduct, RosettaModelObjectBuilder {
		CoalProductType.CoalProductTypeBuilder getOrCreate_type();
		CoalProductType.CoalProductTypeBuilder get_type();
		CoalProductSpecifications.CoalProductSpecificationsBuilder getOrCreateCoalProductSpecifications();
		CoalProductSpecifications.CoalProductSpecificationsBuilder getCoalProductSpecifications();
		CoalProductSource.CoalProductSourceBuilder getOrCreateSource(int _index);
		List<? extends CoalProductSource.CoalProductSourceBuilder> getSource();
		CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder getOrCreateCommodityUSCoalProductModel();
		CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder getCommodityUSCoalProductModel();
		CoalProduct.CoalProductBuilder set_type(CoalProductType _type);
		CoalProduct.CoalProductBuilder setCoalProductSpecifications(CoalProductSpecifications coalProductSpecifications);
		CoalProduct.CoalProductBuilder addSource(CoalProductSource source0);
		CoalProduct.CoalProductBuilder addSource(CoalProductSource source1, int _idx);
		CoalProduct.CoalProductBuilder addSource(List<? extends CoalProductSource> source2);
		CoalProduct.CoalProductBuilder setSource(List<? extends CoalProductSource> source3);
		CoalProduct.CoalProductBuilder setSCoTASpecifications(Boolean sCoTASpecifications);
		CoalProduct.CoalProductBuilder setCommodityUSCoalProductModel(CommodityUSCoalProductModel commodityUSCoalProductModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("_type"), processor, CoalProductType.CoalProductTypeBuilder.class, get_type());
			processRosetta(path.newSubPath("coalProductSpecifications"), processor, CoalProductSpecifications.CoalProductSpecificationsBuilder.class, getCoalProductSpecifications());
			processRosetta(path.newSubPath("source"), processor, CoalProductSource.CoalProductSourceBuilder.class, getSource());
			processor.processBasic(path.newSubPath("sCoTASpecifications"), Boolean.class, getSCoTASpecifications(), this);
			processRosetta(path.newSubPath("commodityUSCoalProductModel"), processor, CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder.class, getCommodityUSCoalProductModel());
		}
		

		CoalProduct.CoalProductBuilder prune();
	}

	/*********************** Immutable Implementation of CoalProduct  ***********************/
	class CoalProductImpl implements CoalProduct {
		private final CoalProductType _type;
		private final CoalProductSpecifications coalProductSpecifications;
		private final List<? extends CoalProductSource> source;
		private final Boolean sCoTASpecifications;
		private final CommodityUSCoalProductModel commodityUSCoalProductModel;
		
		protected CoalProductImpl(CoalProduct.CoalProductBuilder builder) {
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
			this.coalProductSpecifications = ofNullable(builder.getCoalProductSpecifications()).map(f->f.build()).orElse(null);
			this.source = ofNullable(builder.getSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.sCoTASpecifications = builder.getSCoTASpecifications();
			this.commodityUSCoalProductModel = ofNullable(builder.getCommodityUSCoalProductModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("_type")
		public CoalProductType get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("coalProductSpecifications")
		public CoalProductSpecifications getCoalProductSpecifications() {
			return coalProductSpecifications;
		}
		
		@Override
		@RosettaAttribute("source")
		public List<? extends CoalProductSource> getSource() {
			return source;
		}
		
		@Override
		@RosettaAttribute("sCoTASpecifications")
		public Boolean getSCoTASpecifications() {
			return sCoTASpecifications;
		}
		
		@Override
		@RosettaAttribute("commodityUSCoalProductModel")
		public CommodityUSCoalProductModel getCommodityUSCoalProductModel() {
			return commodityUSCoalProductModel;
		}
		
		@Override
		public CoalProduct build() {
			return this;
		}
		
		@Override
		public CoalProduct.CoalProductBuilder toBuilder() {
			CoalProduct.CoalProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalProduct.CoalProductBuilder builder) {
			ofNullable(get_type()).ifPresent(builder::set_type);
			ofNullable(getCoalProductSpecifications()).ifPresent(builder::setCoalProductSpecifications);
			ofNullable(getSource()).ifPresent(builder::setSource);
			ofNullable(getSCoTASpecifications()).ifPresent(builder::setSCoTASpecifications);
			ofNullable(getCommodityUSCoalProductModel()).ifPresent(builder::setCommodityUSCoalProductModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalProduct _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(coalProductSpecifications, _that.getCoalProductSpecifications())) return false;
			if (!ListEquals.listEquals(source, _that.getSource())) return false;
			if (!Objects.equals(sCoTASpecifications, _that.getSCoTASpecifications())) return false;
			if (!Objects.equals(commodityUSCoalProductModel, _that.getCommodityUSCoalProductModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (coalProductSpecifications != null ? coalProductSpecifications.hashCode() : 0);
			_result = 31 * _result + (source != null ? source.hashCode() : 0);
			_result = 31 * _result + (sCoTASpecifications != null ? sCoTASpecifications.hashCode() : 0);
			_result = 31 * _result + (commodityUSCoalProductModel != null ? commodityUSCoalProductModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalProduct {" +
				"_type=" + this._type + ", " +
				"coalProductSpecifications=" + this.coalProductSpecifications + ", " +
				"source=" + this.source + ", " +
				"sCoTASpecifications=" + this.sCoTASpecifications + ", " +
				"commodityUSCoalProductModel=" + this.commodityUSCoalProductModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalProduct  ***********************/
	class CoalProductBuilderImpl implements CoalProduct.CoalProductBuilder {
	
		protected CoalProductType.CoalProductTypeBuilder _type;
		protected CoalProductSpecifications.CoalProductSpecificationsBuilder coalProductSpecifications;
		protected List<CoalProductSource.CoalProductSourceBuilder> source = new ArrayList<>();
		protected Boolean sCoTASpecifications;
		protected CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder commodityUSCoalProductModel;
	
		public CoalProductBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("_type")
		public CoalProductType.CoalProductTypeBuilder get_type() {
			return _type;
		}
		
		@Override
		public CoalProductType.CoalProductTypeBuilder getOrCreate_type() {
			CoalProductType.CoalProductTypeBuilder result;
			if (_type!=null) {
				result = _type;
			}
			else {
				result = _type = CoalProductType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coalProductSpecifications")
		public CoalProductSpecifications.CoalProductSpecificationsBuilder getCoalProductSpecifications() {
			return coalProductSpecifications;
		}
		
		@Override
		public CoalProductSpecifications.CoalProductSpecificationsBuilder getOrCreateCoalProductSpecifications() {
			CoalProductSpecifications.CoalProductSpecificationsBuilder result;
			if (coalProductSpecifications!=null) {
				result = coalProductSpecifications;
			}
			else {
				result = coalProductSpecifications = CoalProductSpecifications.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("source")
		public List<? extends CoalProductSource.CoalProductSourceBuilder> getSource() {
			return source;
		}
		
		@Override
		public CoalProductSource.CoalProductSourceBuilder getOrCreateSource(int _index) {
		
			if (source==null) {
				this.source = new ArrayList<>();
			}
			CoalProductSource.CoalProductSourceBuilder result;
			return getIndex(source, _index, () -> {
						CoalProductSource.CoalProductSourceBuilder newSource = CoalProductSource.builder();
						return newSource;
					});
		}
		
		@Override
		@RosettaAttribute("sCoTASpecifications")
		public Boolean getSCoTASpecifications() {
			return sCoTASpecifications;
		}
		
		@Override
		@RosettaAttribute("commodityUSCoalProductModel")
		public CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder getCommodityUSCoalProductModel() {
			return commodityUSCoalProductModel;
		}
		
		@Override
		public CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder getOrCreateCommodityUSCoalProductModel() {
			CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder result;
			if (commodityUSCoalProductModel!=null) {
				result = commodityUSCoalProductModel;
			}
			else {
				result = commodityUSCoalProductModel = CommodityUSCoalProductModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("_type")
		public CoalProduct.CoalProductBuilder set_type(CoalProductType _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("coalProductSpecifications")
		public CoalProduct.CoalProductBuilder setCoalProductSpecifications(CoalProductSpecifications coalProductSpecifications) {
			this.coalProductSpecifications = coalProductSpecifications==null?null:coalProductSpecifications.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("source")
		public CoalProduct.CoalProductBuilder addSource(CoalProductSource source) {
			if (source!=null) this.source.add(source.toBuilder());
			return this;
		}
		
		@Override
		public CoalProduct.CoalProductBuilder addSource(CoalProductSource source, int _idx) {
			getIndex(this.source, _idx, () -> source.toBuilder());
			return this;
		}
		@Override 
		public CoalProduct.CoalProductBuilder addSource(List<? extends CoalProductSource> sources) {
			if (sources != null) {
				for (CoalProductSource toAdd : sources) {
					this.source.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CoalProduct.CoalProductBuilder setSource(List<? extends CoalProductSource> sources) {
			if (sources == null)  {
				this.source = new ArrayList<>();
			}
			else {
				this.source = sources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("sCoTASpecifications")
		public CoalProduct.CoalProductBuilder setSCoTASpecifications(Boolean sCoTASpecifications) {
			this.sCoTASpecifications = sCoTASpecifications==null?null:sCoTASpecifications;
			return this;
		}
		@Override
		@RosettaAttribute("commodityUSCoalProductModel")
		public CoalProduct.CoalProductBuilder setCommodityUSCoalProductModel(CommodityUSCoalProductModel commodityUSCoalProductModel) {
			this.commodityUSCoalProductModel = commodityUSCoalProductModel==null?null:commodityUSCoalProductModel.toBuilder();
			return this;
		}
		
		@Override
		public CoalProduct build() {
			return new CoalProduct.CoalProductImpl(this);
		}
		
		@Override
		public CoalProduct.CoalProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalProduct.CoalProductBuilder prune() {
			if (_type!=null && !_type.prune().hasData()) _type = null;
			if (coalProductSpecifications!=null && !coalProductSpecifications.prune().hasData()) coalProductSpecifications = null;
			source = source.stream().filter(b->b!=null).<CoalProductSource.CoalProductSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityUSCoalProductModel!=null && !commodityUSCoalProductModel.prune().hasData()) commodityUSCoalProductModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (get_type()!=null && get_type().hasData()) return true;
			if (getCoalProductSpecifications()!=null && getCoalProductSpecifications().hasData()) return true;
			if (getSource()!=null && getSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSCoTASpecifications()!=null) return true;
			if (getCommodityUSCoalProductModel()!=null && getCommodityUSCoalProductModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalProduct.CoalProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalProduct.CoalProductBuilder o = (CoalProduct.CoalProductBuilder) other;
			
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			merger.mergeRosetta(getCoalProductSpecifications(), o.getCoalProductSpecifications(), this::setCoalProductSpecifications);
			merger.mergeRosetta(getSource(), o.getSource(), this::getOrCreateSource);
			merger.mergeRosetta(getCommodityUSCoalProductModel(), o.getCommodityUSCoalProductModel(), this::setCommodityUSCoalProductModel);
			
			merger.mergeBasic(getSCoTASpecifications(), o.getSCoTASpecifications(), this::setSCoTASpecifications);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalProduct _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(coalProductSpecifications, _that.getCoalProductSpecifications())) return false;
			if (!ListEquals.listEquals(source, _that.getSource())) return false;
			if (!Objects.equals(sCoTASpecifications, _that.getSCoTASpecifications())) return false;
			if (!Objects.equals(commodityUSCoalProductModel, _that.getCommodityUSCoalProductModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (coalProductSpecifications != null ? coalProductSpecifications.hashCode() : 0);
			_result = 31 * _result + (source != null ? source.hashCode() : 0);
			_result = 31 * _result + (sCoTASpecifications != null ? sCoTASpecifications.hashCode() : 0);
			_result = 31 * _result + (commodityUSCoalProductModel != null ? commodityUSCoalProductModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalProductBuilder {" +
				"_type=" + this._type + ", " +
				"coalProductSpecifications=" + this.coalProductSpecifications + ", " +
				"source=" + this.source + ", " +
				"sCoTASpecifications=" + this.sCoTASpecifications + ", " +
				"commodityUSCoalProductModel=" + this.commodityUSCoalProductModel +
			'}';
		}
	}
}
