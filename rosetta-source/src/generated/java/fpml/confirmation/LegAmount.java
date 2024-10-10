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
import fpml.confirmation.AdjustableRelativeOrPeriodicDates;
import fpml.confirmation.CurrencyAndDeterminationMethodModel;
import fpml.confirmation.Formula;
import fpml.confirmation.LegAmount;
import fpml.confirmation.LegAmount.LegAmountBuilder;
import fpml.confirmation.LegAmount.LegAmountBuilderImpl;
import fpml.confirmation.LegAmount.LegAmountImpl;
import fpml.confirmation.ReferenceAmount;
import fpml.confirmation.meta.LegAmountMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the amount that will paid or received on each of the payment dates. This type is used to define both the Equity Amount and the Interest Amount.
 * @version ${project.version}
 */
@RosettaDataType(value="LegAmount", builder=LegAmount.LegAmountBuilderImpl.class, version="${project.version}")
public interface LegAmount extends RosettaModelObject {

	LegAmountMeta metaData = new LegAmountMeta();

	/*********************** Getter Methods  ***********************/
	CurrencyAndDeterminationMethodModel getCurrencyAndDeterminationMethodModel();
	/**
	 * Specifies the reference Amount when this term either corresponds to the standard ISDA Definition (either the 2002 Equity Definition for the Equity Amount, or the 2000 Definition for the Interest Amount), or points to a term defined elsewhere in the swap document.
	 */
	ReferenceAmount getReferenceAmount();
	/**
	 * Specifies a formula, with its description and components.
	 */
	Formula getFormula();
	/**
	 * Description of the leg amount when represented through an encoded image.
	 */
	String getEncodedDescription();
	/**
	 * Specifies the date on which a calculation or an observation will be performed for the purpose of defining the Equity Amount, and in accordance to the definition terms of this latter.
	 */
	AdjustableRelativeOrPeriodicDates getCalculationDates();

	/*********************** Build Methods  ***********************/
	LegAmount build();
	
	LegAmount.LegAmountBuilder toBuilder();
	
	static LegAmount.LegAmountBuilder builder() {
		return new LegAmount.LegAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LegAmount> getType() {
		return LegAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currencyAndDeterminationMethodModel"), processor, CurrencyAndDeterminationMethodModel.class, getCurrencyAndDeterminationMethodModel());
		processRosetta(path.newSubPath("referenceAmount"), processor, ReferenceAmount.class, getReferenceAmount());
		processRosetta(path.newSubPath("formula"), processor, Formula.class, getFormula());
		processor.processBasic(path.newSubPath("encodedDescription"), String.class, getEncodedDescription(), this);
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getCalculationDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegAmountBuilder extends LegAmount, RosettaModelObjectBuilder {
		CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder getOrCreateCurrencyAndDeterminationMethodModel();
		CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder getCurrencyAndDeterminationMethodModel();
		ReferenceAmount.ReferenceAmountBuilder getOrCreateReferenceAmount();
		ReferenceAmount.ReferenceAmountBuilder getReferenceAmount();
		Formula.FormulaBuilder getOrCreateFormula();
		Formula.FormulaBuilder getFormula();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateCalculationDates();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getCalculationDates();
		LegAmount.LegAmountBuilder setCurrencyAndDeterminationMethodModel(CurrencyAndDeterminationMethodModel currencyAndDeterminationMethodModel);
		LegAmount.LegAmountBuilder setReferenceAmount(ReferenceAmount referenceAmount);
		LegAmount.LegAmountBuilder setFormula(Formula formula);
		LegAmount.LegAmountBuilder setEncodedDescription(String encodedDescription);
		LegAmount.LegAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currencyAndDeterminationMethodModel"), processor, CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder.class, getCurrencyAndDeterminationMethodModel());
			processRosetta(path.newSubPath("referenceAmount"), processor, ReferenceAmount.ReferenceAmountBuilder.class, getReferenceAmount());
			processRosetta(path.newSubPath("formula"), processor, Formula.FormulaBuilder.class, getFormula());
			processor.processBasic(path.newSubPath("encodedDescription"), String.class, getEncodedDescription(), this);
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
		}
		

		LegAmount.LegAmountBuilder prune();
	}

	/*********************** Immutable Implementation of LegAmount  ***********************/
	class LegAmountImpl implements LegAmount {
		private final CurrencyAndDeterminationMethodModel currencyAndDeterminationMethodModel;
		private final ReferenceAmount referenceAmount;
		private final Formula formula;
		private final String encodedDescription;
		private final AdjustableRelativeOrPeriodicDates calculationDates;
		
		protected LegAmountImpl(LegAmount.LegAmountBuilder builder) {
			this.currencyAndDeterminationMethodModel = ofNullable(builder.getCurrencyAndDeterminationMethodModel()).map(f->f.build()).orElse(null);
			this.referenceAmount = ofNullable(builder.getReferenceAmount()).map(f->f.build()).orElse(null);
			this.formula = ofNullable(builder.getFormula()).map(f->f.build()).orElse(null);
			this.encodedDescription = builder.getEncodedDescription();
			this.calculationDates = ofNullable(builder.getCalculationDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currencyAndDeterminationMethodModel")
		public CurrencyAndDeterminationMethodModel getCurrencyAndDeterminationMethodModel() {
			return currencyAndDeterminationMethodModel;
		}
		
		@Override
		@RosettaAttribute("referenceAmount")
		public ReferenceAmount getReferenceAmount() {
			return referenceAmount;
		}
		
		@Override
		@RosettaAttribute("formula")
		public Formula getFormula() {
			return formula;
		}
		
		@Override
		@RosettaAttribute("encodedDescription")
		public String getEncodedDescription() {
			return encodedDescription;
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		public AdjustableRelativeOrPeriodicDates getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		public LegAmount build() {
			return this;
		}
		
		@Override
		public LegAmount.LegAmountBuilder toBuilder() {
			LegAmount.LegAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegAmount.LegAmountBuilder builder) {
			ofNullable(getCurrencyAndDeterminationMethodModel()).ifPresent(builder::setCurrencyAndDeterminationMethodModel);
			ofNullable(getReferenceAmount()).ifPresent(builder::setReferenceAmount);
			ofNullable(getFormula()).ifPresent(builder::setFormula);
			ofNullable(getEncodedDescription()).ifPresent(builder::setEncodedDescription);
			ofNullable(getCalculationDates()).ifPresent(builder::setCalculationDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegAmount _that = getType().cast(o);
		
			if (!Objects.equals(currencyAndDeterminationMethodModel, _that.getCurrencyAndDeterminationMethodModel())) return false;
			if (!Objects.equals(referenceAmount, _that.getReferenceAmount())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(encodedDescription, _that.getEncodedDescription())) return false;
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currencyAndDeterminationMethodModel != null ? currencyAndDeterminationMethodModel.hashCode() : 0);
			_result = 31 * _result + (referenceAmount != null ? referenceAmount.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			_result = 31 * _result + (encodedDescription != null ? encodedDescription.hashCode() : 0);
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegAmount {" +
				"currencyAndDeterminationMethodModel=" + this.currencyAndDeterminationMethodModel + ", " +
				"referenceAmount=" + this.referenceAmount + ", " +
				"formula=" + this.formula + ", " +
				"encodedDescription=" + this.encodedDescription + ", " +
				"calculationDates=" + this.calculationDates +
			'}';
		}
	}

	/*********************** Builder Implementation of LegAmount  ***********************/
	class LegAmountBuilderImpl implements LegAmount.LegAmountBuilder {
	
		protected CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder currencyAndDeterminationMethodModel;
		protected ReferenceAmount.ReferenceAmountBuilder referenceAmount;
		protected Formula.FormulaBuilder formula;
		protected String encodedDescription;
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder calculationDates;
	
		public LegAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currencyAndDeterminationMethodModel")
		public CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder getCurrencyAndDeterminationMethodModel() {
			return currencyAndDeterminationMethodModel;
		}
		
		@Override
		public CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder getOrCreateCurrencyAndDeterminationMethodModel() {
			CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder result;
			if (currencyAndDeterminationMethodModel!=null) {
				result = currencyAndDeterminationMethodModel;
			}
			else {
				result = currencyAndDeterminationMethodModel = CurrencyAndDeterminationMethodModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceAmount")
		public ReferenceAmount.ReferenceAmountBuilder getReferenceAmount() {
			return referenceAmount;
		}
		
		@Override
		public ReferenceAmount.ReferenceAmountBuilder getOrCreateReferenceAmount() {
			ReferenceAmount.ReferenceAmountBuilder result;
			if (referenceAmount!=null) {
				result = referenceAmount;
			}
			else {
				result = referenceAmount = ReferenceAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("formula")
		public Formula.FormulaBuilder getFormula() {
			return formula;
		}
		
		@Override
		public Formula.FormulaBuilder getOrCreateFormula() {
			Formula.FormulaBuilder result;
			if (formula!=null) {
				result = formula;
			}
			else {
				result = formula = Formula.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("encodedDescription")
		public String getEncodedDescription() {
			return encodedDescription;
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateCalculationDates() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			if (calculationDates!=null) {
				result = calculationDates;
			}
			else {
				result = calculationDates = AdjustableRelativeOrPeriodicDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currencyAndDeterminationMethodModel")
		public LegAmount.LegAmountBuilder setCurrencyAndDeterminationMethodModel(CurrencyAndDeterminationMethodModel currencyAndDeterminationMethodModel) {
			this.currencyAndDeterminationMethodModel = currencyAndDeterminationMethodModel==null?null:currencyAndDeterminationMethodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceAmount")
		public LegAmount.LegAmountBuilder setReferenceAmount(ReferenceAmount referenceAmount) {
			this.referenceAmount = referenceAmount==null?null:referenceAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("formula")
		public LegAmount.LegAmountBuilder setFormula(Formula formula) {
			this.formula = formula==null?null:formula.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("encodedDescription")
		public LegAmount.LegAmountBuilder setEncodedDescription(String encodedDescription) {
			this.encodedDescription = encodedDescription==null?null:encodedDescription;
			return this;
		}
		@Override
		@RosettaAttribute("calculationDates")
		public LegAmount.LegAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates) {
			this.calculationDates = calculationDates==null?null:calculationDates.toBuilder();
			return this;
		}
		
		@Override
		public LegAmount build() {
			return new LegAmount.LegAmountImpl(this);
		}
		
		@Override
		public LegAmount.LegAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegAmount.LegAmountBuilder prune() {
			if (currencyAndDeterminationMethodModel!=null && !currencyAndDeterminationMethodModel.prune().hasData()) currencyAndDeterminationMethodModel = null;
			if (referenceAmount!=null && !referenceAmount.prune().hasData()) referenceAmount = null;
			if (formula!=null && !formula.prune().hasData()) formula = null;
			if (calculationDates!=null && !calculationDates.prune().hasData()) calculationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrencyAndDeterminationMethodModel()!=null && getCurrencyAndDeterminationMethodModel().hasData()) return true;
			if (getReferenceAmount()!=null && getReferenceAmount().hasData()) return true;
			if (getFormula()!=null && getFormula().hasData()) return true;
			if (getEncodedDescription()!=null) return true;
			if (getCalculationDates()!=null && getCalculationDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegAmount.LegAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegAmount.LegAmountBuilder o = (LegAmount.LegAmountBuilder) other;
			
			merger.mergeRosetta(getCurrencyAndDeterminationMethodModel(), o.getCurrencyAndDeterminationMethodModel(), this::setCurrencyAndDeterminationMethodModel);
			merger.mergeRosetta(getReferenceAmount(), o.getReferenceAmount(), this::setReferenceAmount);
			merger.mergeRosetta(getFormula(), o.getFormula(), this::setFormula);
			merger.mergeRosetta(getCalculationDates(), o.getCalculationDates(), this::setCalculationDates);
			
			merger.mergeBasic(getEncodedDescription(), o.getEncodedDescription(), this::setEncodedDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegAmount _that = getType().cast(o);
		
			if (!Objects.equals(currencyAndDeterminationMethodModel, _that.getCurrencyAndDeterminationMethodModel())) return false;
			if (!Objects.equals(referenceAmount, _that.getReferenceAmount())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(encodedDescription, _that.getEncodedDescription())) return false;
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currencyAndDeterminationMethodModel != null ? currencyAndDeterminationMethodModel.hashCode() : 0);
			_result = 31 * _result + (referenceAmount != null ? referenceAmount.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			_result = 31 * _result + (encodedDescription != null ? encodedDescription.hashCode() : 0);
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegAmountBuilder {" +
				"currencyAndDeterminationMethodModel=" + this.currencyAndDeterminationMethodModel + ", " +
				"referenceAmount=" + this.referenceAmount + ", " +
				"formula=" + this.formula + ", " +
				"encodedDescription=" + this.encodedDescription + ", " +
				"calculationDates=" + this.calculationDates +
			'}';
		}
	}
}
