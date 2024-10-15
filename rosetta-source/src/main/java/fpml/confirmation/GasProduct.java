package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.GasProduct;
import fpml.confirmation.GasProduct.GasProductBuilder;
import fpml.confirmation.GasProduct.GasProductBuilderImpl;
import fpml.confirmation.GasProduct.GasProductImpl;
import fpml.confirmation.GasProductTypeEnum;
import fpml.confirmation.GasQuality;
import fpml.confirmation.meta.GasProductMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the characteristics of the gas being traded in a physically settled gas transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="GasProduct", builder=GasProduct.GasProductBuilderImpl.class, version="${project.version}")
public interface GasProduct extends RosettaModelObject {

	GasProductMeta metaData = new GasProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of gas to be delivered.
	 */
	GasProductTypeEnum get_type();
	/**
	 * The calorific value of the gas to be delivered, specified in megajoules per cubic meter (MJ/m3).
	 */
	BigDecimal getCalorificValue();
	/**
	 * The quality of the gas to be delivered.
	 */
	GasQuality getQuality();

	/*********************** Build Methods  ***********************/
	GasProduct build();
	
	GasProduct.GasProductBuilder toBuilder();
	
	static GasProduct.GasProductBuilder builder() {
		return new GasProduct.GasProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasProduct> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GasProduct> getType() {
		return GasProduct.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("_type"), GasProductTypeEnum.class, get_type(), this);
		processor.processBasic(path.newSubPath("calorificValue"), BigDecimal.class, getCalorificValue(), this);
		processRosetta(path.newSubPath("quality"), processor, GasQuality.class, getQuality());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasProductBuilder extends GasProduct, RosettaModelObjectBuilder {
		GasQuality.GasQualityBuilder getOrCreateQuality();
		GasQuality.GasQualityBuilder getQuality();
		GasProduct.GasProductBuilder set_type(GasProductTypeEnum _type);
		GasProduct.GasProductBuilder setCalorificValue(BigDecimal calorificValue);
		GasProduct.GasProductBuilder setQuality(GasQuality quality);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("_type"), GasProductTypeEnum.class, get_type(), this);
			processor.processBasic(path.newSubPath("calorificValue"), BigDecimal.class, getCalorificValue(), this);
			processRosetta(path.newSubPath("quality"), processor, GasQuality.GasQualityBuilder.class, getQuality());
		}
		

		GasProduct.GasProductBuilder prune();
	}

	/*********************** Immutable Implementation of GasProduct  ***********************/
	class GasProductImpl implements GasProduct {
		private final GasProductTypeEnum _type;
		private final BigDecimal calorificValue;
		private final GasQuality quality;
		
		protected GasProductImpl(GasProduct.GasProductBuilder builder) {
			this._type = builder.get_type();
			this.calorificValue = builder.getCalorificValue();
			this.quality = ofNullable(builder.getQuality()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("_type")
		public GasProductTypeEnum get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("calorificValue")
		public BigDecimal getCalorificValue() {
			return calorificValue;
		}
		
		@Override
		@RosettaAttribute("quality")
		public GasQuality getQuality() {
			return quality;
		}
		
		@Override
		public GasProduct build() {
			return this;
		}
		
		@Override
		public GasProduct.GasProductBuilder toBuilder() {
			GasProduct.GasProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasProduct.GasProductBuilder builder) {
			ofNullable(get_type()).ifPresent(builder::set_type);
			ofNullable(getCalorificValue()).ifPresent(builder::setCalorificValue);
			ofNullable(getQuality()).ifPresent(builder::setQuality);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasProduct _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(calorificValue, _that.getCalorificValue())) return false;
			if (!Objects.equals(quality, _that.getQuality())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_type != null ? _type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calorificValue != null ? calorificValue.hashCode() : 0);
			_result = 31 * _result + (quality != null ? quality.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasProduct {" +
				"_type=" + this._type + ", " +
				"calorificValue=" + this.calorificValue + ", " +
				"quality=" + this.quality +
			'}';
		}
	}

	/*********************** Builder Implementation of GasProduct  ***********************/
	class GasProductBuilderImpl implements GasProduct.GasProductBuilder {
	
		protected GasProductTypeEnum _type;
		protected BigDecimal calorificValue;
		protected GasQuality.GasQualityBuilder quality;
	
		public GasProductBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("_type")
		public GasProductTypeEnum get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("calorificValue")
		public BigDecimal getCalorificValue() {
			return calorificValue;
		}
		
		@Override
		@RosettaAttribute("quality")
		public GasQuality.GasQualityBuilder getQuality() {
			return quality;
		}
		
		@Override
		public GasQuality.GasQualityBuilder getOrCreateQuality() {
			GasQuality.GasQualityBuilder result;
			if (quality!=null) {
				result = quality;
			}
			else {
				result = quality = GasQuality.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("_type")
		public GasProduct.GasProductBuilder set_type(GasProductTypeEnum _type) {
			this._type = _type==null?null:_type;
			return this;
		}
		@Override
		@RosettaAttribute("calorificValue")
		public GasProduct.GasProductBuilder setCalorificValue(BigDecimal calorificValue) {
			this.calorificValue = calorificValue==null?null:calorificValue;
			return this;
		}
		@Override
		@RosettaAttribute("quality")
		public GasProduct.GasProductBuilder setQuality(GasQuality quality) {
			this.quality = quality==null?null:quality.toBuilder();
			return this;
		}
		
		@Override
		public GasProduct build() {
			return new GasProduct.GasProductImpl(this);
		}
		
		@Override
		public GasProduct.GasProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasProduct.GasProductBuilder prune() {
			if (quality!=null && !quality.prune().hasData()) quality = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (get_type()!=null) return true;
			if (getCalorificValue()!=null) return true;
			if (getQuality()!=null && getQuality().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasProduct.GasProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GasProduct.GasProductBuilder o = (GasProduct.GasProductBuilder) other;
			
			merger.mergeRosetta(getQuality(), o.getQuality(), this::setQuality);
			
			merger.mergeBasic(get_type(), o.get_type(), this::set_type);
			merger.mergeBasic(getCalorificValue(), o.getCalorificValue(), this::setCalorificValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasProduct _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(calorificValue, _that.getCalorificValue())) return false;
			if (!Objects.equals(quality, _that.getQuality())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_type != null ? _type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calorificValue != null ? calorificValue.hashCode() : 0);
			_result = 31 * _result + (quality != null ? quality.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasProductBuilder {" +
				"_type=" + this._type + ", " +
				"calorificValue=" + this.calorificValue + ", " +
				"quality=" + this.quality +
			'}';
		}
	}
}
