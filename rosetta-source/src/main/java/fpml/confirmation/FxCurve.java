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
import fpml.confirmation.FxCurve;
import fpml.confirmation.FxCurve.FxCurveBuilder;
import fpml.confirmation.FxCurve.FxCurveBuilderImpl;
import fpml.confirmation.FxCurve.FxCurveImpl;
import fpml.confirmation.FxCurveCharacteristicsModel;
import fpml.confirmation.PricingStructure;
import fpml.confirmation.PricingStructure.PricingStructureBuilder;
import fpml.confirmation.PricingStructure.PricingStructureBuilderImpl;
import fpml.confirmation.PricingStructure.PricingStructureImpl;
import fpml.confirmation.meta.FxCurveMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An fx curve object., which includes pricing inputs and term structures for fx forwards.
 * @version ${project.version}
 */
@RosettaDataType(value="FxCurve", builder=FxCurve.FxCurveBuilderImpl.class, version="${project.version}")
public interface FxCurve extends PricingStructure {

	FxCurveMeta metaData = new FxCurveMeta();

	/*********************** Getter Methods  ***********************/
	FxCurveCharacteristicsModel getFxCurveCharacteristicsModel();

	/*********************** Build Methods  ***********************/
	FxCurve build();
	
	FxCurve.FxCurveBuilder toBuilder();
	
	static FxCurve.FxCurveBuilder builder() {
		return new FxCurve.FxCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCurve> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxCurve> getType() {
		return FxCurve.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("fxCurveCharacteristicsModel"), processor, FxCurveCharacteristicsModel.class, getFxCurveCharacteristicsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCurveBuilder extends FxCurve, PricingStructure.PricingStructureBuilder {
		FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder getOrCreateFxCurveCharacteristicsModel();
		FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder getFxCurveCharacteristicsModel();
		FxCurve.FxCurveBuilder setName(String name);
		FxCurve.FxCurveBuilder setCurrency(Currency currency);
		FxCurve.FxCurveBuilder setId(String id);
		FxCurve.FxCurveBuilder setFxCurveCharacteristicsModel(FxCurveCharacteristicsModel fxCurveCharacteristicsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("fxCurveCharacteristicsModel"), processor, FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder.class, getFxCurveCharacteristicsModel());
		}
		

		FxCurve.FxCurveBuilder prune();
	}

	/*********************** Immutable Implementation of FxCurve  ***********************/
	class FxCurveImpl extends PricingStructure.PricingStructureImpl implements FxCurve {
		private final FxCurveCharacteristicsModel fxCurveCharacteristicsModel;
		
		protected FxCurveImpl(FxCurve.FxCurveBuilder builder) {
			super(builder);
			this.fxCurveCharacteristicsModel = ofNullable(builder.getFxCurveCharacteristicsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxCurveCharacteristicsModel")
		public FxCurveCharacteristicsModel getFxCurveCharacteristicsModel() {
			return fxCurveCharacteristicsModel;
		}
		
		@Override
		public FxCurve build() {
			return this;
		}
		
		@Override
		public FxCurve.FxCurveBuilder toBuilder() {
			FxCurve.FxCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCurve.FxCurveBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFxCurveCharacteristicsModel()).ifPresent(builder::setFxCurveCharacteristicsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCurve _that = getType().cast(o);
		
			if (!Objects.equals(fxCurveCharacteristicsModel, _that.getFxCurveCharacteristicsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fxCurveCharacteristicsModel != null ? fxCurveCharacteristicsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCurve {" +
				"fxCurveCharacteristicsModel=" + this.fxCurveCharacteristicsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxCurve  ***********************/
	class FxCurveBuilderImpl extends PricingStructure.PricingStructureBuilderImpl  implements FxCurve.FxCurveBuilder {
	
		protected FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder fxCurveCharacteristicsModel;
	
		public FxCurveBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxCurveCharacteristicsModel")
		public FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder getFxCurveCharacteristicsModel() {
			return fxCurveCharacteristicsModel;
		}
		
		@Override
		public FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder getOrCreateFxCurveCharacteristicsModel() {
			FxCurveCharacteristicsModel.FxCurveCharacteristicsModelBuilder result;
			if (fxCurveCharacteristicsModel!=null) {
				result = fxCurveCharacteristicsModel;
			}
			else {
				result = fxCurveCharacteristicsModel = FxCurveCharacteristicsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("name")
		public FxCurve.FxCurveBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public FxCurve.FxCurveBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxCurve.FxCurveBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("fxCurveCharacteristicsModel")
		public FxCurve.FxCurveBuilder setFxCurveCharacteristicsModel(FxCurveCharacteristicsModel fxCurveCharacteristicsModel) {
			this.fxCurveCharacteristicsModel = fxCurveCharacteristicsModel==null?null:fxCurveCharacteristicsModel.toBuilder();
			return this;
		}
		
		@Override
		public FxCurve build() {
			return new FxCurve.FxCurveImpl(this);
		}
		
		@Override
		public FxCurve.FxCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCurve.FxCurveBuilder prune() {
			super.prune();
			if (fxCurveCharacteristicsModel!=null && !fxCurveCharacteristicsModel.prune().hasData()) fxCurveCharacteristicsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFxCurveCharacteristicsModel()!=null && getFxCurveCharacteristicsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCurve.FxCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxCurve.FxCurveBuilder o = (FxCurve.FxCurveBuilder) other;
			
			merger.mergeRosetta(getFxCurveCharacteristicsModel(), o.getFxCurveCharacteristicsModel(), this::setFxCurveCharacteristicsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCurve _that = getType().cast(o);
		
			if (!Objects.equals(fxCurveCharacteristicsModel, _that.getFxCurveCharacteristicsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fxCurveCharacteristicsModel != null ? fxCurveCharacteristicsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCurveBuilder {" +
				"fxCurveCharacteristicsModel=" + this.fxCurveCharacteristicsModel +
			'}' + " " + super.toString();
		}
	}
}
