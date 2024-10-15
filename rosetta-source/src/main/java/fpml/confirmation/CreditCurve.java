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
import fpml.confirmation.CreditCurve;
import fpml.confirmation.CreditCurve.CreditCurveBuilder;
import fpml.confirmation.CreditCurve.CreditCurveBuilderImpl;
import fpml.confirmation.CreditCurve.CreditCurveImpl;
import fpml.confirmation.CreditCurveCharacteristicsModel;
import fpml.confirmation.Currency;
import fpml.confirmation.PricingStructure;
import fpml.confirmation.PricingStructure.PricingStructureBuilder;
import fpml.confirmation.PricingStructure.PricingStructureBuilderImpl;
import fpml.confirmation.PricingStructure.PricingStructureImpl;
import fpml.confirmation.meta.CreditCurveMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A generic credit curve definition.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditCurve", builder=CreditCurve.CreditCurveBuilderImpl.class, version="${project.version}")
public interface CreditCurve extends PricingStructure {

	CreditCurveMeta metaData = new CreditCurveMeta();

	/*********************** Getter Methods  ***********************/
	CreditCurveCharacteristicsModel getCreditCurveCharacteristicsModel();

	/*********************** Build Methods  ***********************/
	CreditCurve build();
	
	CreditCurve.CreditCurveBuilder toBuilder();
	
	static CreditCurve.CreditCurveBuilder builder() {
		return new CreditCurve.CreditCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditCurve> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditCurve> getType() {
		return CreditCurve.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("creditCurveCharacteristicsModel"), processor, CreditCurveCharacteristicsModel.class, getCreditCurveCharacteristicsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditCurveBuilder extends CreditCurve, PricingStructure.PricingStructureBuilder {
		CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder getOrCreateCreditCurveCharacteristicsModel();
		CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder getCreditCurveCharacteristicsModel();
		CreditCurve.CreditCurveBuilder setName(String name);
		CreditCurve.CreditCurveBuilder setCurrency(Currency currency);
		CreditCurve.CreditCurveBuilder setId(String id);
		CreditCurve.CreditCurveBuilder setCreditCurveCharacteristicsModel(CreditCurveCharacteristicsModel creditCurveCharacteristicsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("creditCurveCharacteristicsModel"), processor, CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder.class, getCreditCurveCharacteristicsModel());
		}
		

		CreditCurve.CreditCurveBuilder prune();
	}

	/*********************** Immutable Implementation of CreditCurve  ***********************/
	class CreditCurveImpl extends PricingStructure.PricingStructureImpl implements CreditCurve {
		private final CreditCurveCharacteristicsModel creditCurveCharacteristicsModel;
		
		protected CreditCurveImpl(CreditCurve.CreditCurveBuilder builder) {
			super(builder);
			this.creditCurveCharacteristicsModel = ofNullable(builder.getCreditCurveCharacteristicsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditCurveCharacteristicsModel")
		public CreditCurveCharacteristicsModel getCreditCurveCharacteristicsModel() {
			return creditCurveCharacteristicsModel;
		}
		
		@Override
		public CreditCurve build() {
			return this;
		}
		
		@Override
		public CreditCurve.CreditCurveBuilder toBuilder() {
			CreditCurve.CreditCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditCurve.CreditCurveBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCreditCurveCharacteristicsModel()).ifPresent(builder::setCreditCurveCharacteristicsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditCurve _that = getType().cast(o);
		
			if (!Objects.equals(creditCurveCharacteristicsModel, _that.getCreditCurveCharacteristicsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditCurveCharacteristicsModel != null ? creditCurveCharacteristicsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditCurve {" +
				"creditCurveCharacteristicsModel=" + this.creditCurveCharacteristicsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditCurve  ***********************/
	class CreditCurveBuilderImpl extends PricingStructure.PricingStructureBuilderImpl  implements CreditCurve.CreditCurveBuilder {
	
		protected CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder creditCurveCharacteristicsModel;
	
		public CreditCurveBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("creditCurveCharacteristicsModel")
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder getCreditCurveCharacteristicsModel() {
			return creditCurveCharacteristicsModel;
		}
		
		@Override
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder getOrCreateCreditCurveCharacteristicsModel() {
			CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder result;
			if (creditCurveCharacteristicsModel!=null) {
				result = creditCurveCharacteristicsModel;
			}
			else {
				result = creditCurveCharacteristicsModel = CreditCurveCharacteristicsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("name")
		public CreditCurve.CreditCurveBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public CreditCurve.CreditCurveBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CreditCurve.CreditCurveBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("creditCurveCharacteristicsModel")
		public CreditCurve.CreditCurveBuilder setCreditCurveCharacteristicsModel(CreditCurveCharacteristicsModel creditCurveCharacteristicsModel) {
			this.creditCurveCharacteristicsModel = creditCurveCharacteristicsModel==null?null:creditCurveCharacteristicsModel.toBuilder();
			return this;
		}
		
		@Override
		public CreditCurve build() {
			return new CreditCurve.CreditCurveImpl(this);
		}
		
		@Override
		public CreditCurve.CreditCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditCurve.CreditCurveBuilder prune() {
			super.prune();
			if (creditCurveCharacteristicsModel!=null && !creditCurveCharacteristicsModel.prune().hasData()) creditCurveCharacteristicsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCreditCurveCharacteristicsModel()!=null && getCreditCurveCharacteristicsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditCurve.CreditCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditCurve.CreditCurveBuilder o = (CreditCurve.CreditCurveBuilder) other;
			
			merger.mergeRosetta(getCreditCurveCharacteristicsModel(), o.getCreditCurveCharacteristicsModel(), this::setCreditCurveCharacteristicsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditCurve _that = getType().cast(o);
		
			if (!Objects.equals(creditCurveCharacteristicsModel, _that.getCreditCurveCharacteristicsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditCurveCharacteristicsModel != null ? creditCurveCharacteristicsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditCurveBuilder {" +
				"creditCurveCharacteristicsModel=" + this.creditCurveCharacteristicsModel +
			'}' + " " + super.toString();
		}
	}
}
