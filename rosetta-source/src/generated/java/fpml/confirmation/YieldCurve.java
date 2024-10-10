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
import fpml.confirmation.Currency;
import fpml.confirmation.PricingStructure;
import fpml.confirmation.PricingStructure.PricingStructureBuilder;
import fpml.confirmation.PricingStructure.PricingStructureBuilderImpl;
import fpml.confirmation.PricingStructure.PricingStructureImpl;
import fpml.confirmation.YieldCurve;
import fpml.confirmation.YieldCurve.YieldCurveBuilder;
import fpml.confirmation.YieldCurve.YieldCurveBuilderImpl;
import fpml.confirmation.YieldCurve.YieldCurveImpl;
import fpml.confirmation.YieldCurveCharacteristicsModel;
import fpml.confirmation.meta.YieldCurveMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A generic yield curve object, which can be valued in a variety of ways.
 * @version ${project.version}
 */
@RosettaDataType(value="YieldCurve", builder=YieldCurve.YieldCurveBuilderImpl.class, version="${project.version}")
public interface YieldCurve extends PricingStructure {

	YieldCurveMeta metaData = new YieldCurveMeta();

	/*********************** Getter Methods  ***********************/
	YieldCurveCharacteristicsModel getYieldCurveCharacteristicsModel();

	/*********************** Build Methods  ***********************/
	YieldCurve build();
	
	YieldCurve.YieldCurveBuilder toBuilder();
	
	static YieldCurve.YieldCurveBuilder builder() {
		return new YieldCurve.YieldCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends YieldCurve> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends YieldCurve> getType() {
		return YieldCurve.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("yieldCurveCharacteristicsModel"), processor, YieldCurveCharacteristicsModel.class, getYieldCurveCharacteristicsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface YieldCurveBuilder extends YieldCurve, PricingStructure.PricingStructureBuilder {
		YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder getOrCreateYieldCurveCharacteristicsModel();
		YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder getYieldCurveCharacteristicsModel();
		YieldCurve.YieldCurveBuilder setName(String name);
		YieldCurve.YieldCurveBuilder setCurrency(Currency currency);
		YieldCurve.YieldCurveBuilder setId(String id);
		YieldCurve.YieldCurveBuilder setYieldCurveCharacteristicsModel(YieldCurveCharacteristicsModel yieldCurveCharacteristicsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("yieldCurveCharacteristicsModel"), processor, YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder.class, getYieldCurveCharacteristicsModel());
		}
		

		YieldCurve.YieldCurveBuilder prune();
	}

	/*********************** Immutable Implementation of YieldCurve  ***********************/
	class YieldCurveImpl extends PricingStructure.PricingStructureImpl implements YieldCurve {
		private final YieldCurveCharacteristicsModel yieldCurveCharacteristicsModel;
		
		protected YieldCurveImpl(YieldCurve.YieldCurveBuilder builder) {
			super(builder);
			this.yieldCurveCharacteristicsModel = ofNullable(builder.getYieldCurveCharacteristicsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("yieldCurveCharacteristicsModel")
		public YieldCurveCharacteristicsModel getYieldCurveCharacteristicsModel() {
			return yieldCurveCharacteristicsModel;
		}
		
		@Override
		public YieldCurve build() {
			return this;
		}
		
		@Override
		public YieldCurve.YieldCurveBuilder toBuilder() {
			YieldCurve.YieldCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(YieldCurve.YieldCurveBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getYieldCurveCharacteristicsModel()).ifPresent(builder::setYieldCurveCharacteristicsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			YieldCurve _that = getType().cast(o);
		
			if (!Objects.equals(yieldCurveCharacteristicsModel, _that.getYieldCurveCharacteristicsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (yieldCurveCharacteristicsModel != null ? yieldCurveCharacteristicsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurve {" +
				"yieldCurveCharacteristicsModel=" + this.yieldCurveCharacteristicsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of YieldCurve  ***********************/
	class YieldCurveBuilderImpl extends PricingStructure.PricingStructureBuilderImpl  implements YieldCurve.YieldCurveBuilder {
	
		protected YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder yieldCurveCharacteristicsModel;
	
		public YieldCurveBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("yieldCurveCharacteristicsModel")
		public YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder getYieldCurveCharacteristicsModel() {
			return yieldCurveCharacteristicsModel;
		}
		
		@Override
		public YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder getOrCreateYieldCurveCharacteristicsModel() {
			YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder result;
			if (yieldCurveCharacteristicsModel!=null) {
				result = yieldCurveCharacteristicsModel;
			}
			else {
				result = yieldCurveCharacteristicsModel = YieldCurveCharacteristicsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("name")
		public YieldCurve.YieldCurveBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public YieldCurve.YieldCurveBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public YieldCurve.YieldCurveBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("yieldCurveCharacteristicsModel")
		public YieldCurve.YieldCurveBuilder setYieldCurveCharacteristicsModel(YieldCurveCharacteristicsModel yieldCurveCharacteristicsModel) {
			this.yieldCurveCharacteristicsModel = yieldCurveCharacteristicsModel==null?null:yieldCurveCharacteristicsModel.toBuilder();
			return this;
		}
		
		@Override
		public YieldCurve build() {
			return new YieldCurve.YieldCurveImpl(this);
		}
		
		@Override
		public YieldCurve.YieldCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurve.YieldCurveBuilder prune() {
			super.prune();
			if (yieldCurveCharacteristicsModel!=null && !yieldCurveCharacteristicsModel.prune().hasData()) yieldCurveCharacteristicsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getYieldCurveCharacteristicsModel()!=null && getYieldCurveCharacteristicsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurve.YieldCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			YieldCurve.YieldCurveBuilder o = (YieldCurve.YieldCurveBuilder) other;
			
			merger.mergeRosetta(getYieldCurveCharacteristicsModel(), o.getYieldCurveCharacteristicsModel(), this::setYieldCurveCharacteristicsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			YieldCurve _that = getType().cast(o);
		
			if (!Objects.equals(yieldCurveCharacteristicsModel, _that.getYieldCurveCharacteristicsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (yieldCurveCharacteristicsModel != null ? yieldCurveCharacteristicsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurveBuilder {" +
				"yieldCurveCharacteristicsModel=" + this.yieldCurveCharacteristicsModel +
			'}' + " " + super.toString();
		}
	}
}
