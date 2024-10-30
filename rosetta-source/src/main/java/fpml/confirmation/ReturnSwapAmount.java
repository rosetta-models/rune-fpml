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
import fpml.confirmation.DividendsModel;
import fpml.confirmation.Formula;
import fpml.confirmation.LegAmount;
import fpml.confirmation.LegAmount.LegAmountBuilder;
import fpml.confirmation.LegAmount.LegAmountBuilderImpl;
import fpml.confirmation.LegAmount.LegAmountImpl;
import fpml.confirmation.ReferenceAmount;
import fpml.confirmation.ReturnSwapAmount;
import fpml.confirmation.ReturnSwapAmount.ReturnSwapAmountBuilder;
import fpml.confirmation.ReturnSwapAmount.ReturnSwapAmountBuilderImpl;
import fpml.confirmation.ReturnSwapAmount.ReturnSwapAmountImpl;
import fpml.confirmation.meta.ReturnSwapAmountMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies, in relation to each Payment Date, the amount to which the Payment Date relates. For Equity Swaps this element is equivalent to the Equity Amount term as defined in the ISDA 2002 Equity Derivatives Definitions.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ReturnSwapAmount", builder=ReturnSwapAmount.ReturnSwapAmountBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ReturnSwapAmount extends LegAmount {

	ReturnSwapAmountMeta metaData = new ReturnSwapAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If true, then cash settlement is applicable.
	 */
	Boolean getCashSettlement();
	DividendsModel getDividendsModel();

	/*********************** Build Methods  ***********************/
	ReturnSwapAmount build();
	
	ReturnSwapAmount.ReturnSwapAmountBuilder toBuilder();
	
	static ReturnSwapAmount.ReturnSwapAmountBuilder builder() {
		return new ReturnSwapAmount.ReturnSwapAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnSwapAmount> getType() {
		return ReturnSwapAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currencyAndDeterminationMethodModel"), processor, CurrencyAndDeterminationMethodModel.class, getCurrencyAndDeterminationMethodModel());
		processRosetta(path.newSubPath("referenceAmount"), processor, ReferenceAmount.class, getReferenceAmount());
		processRosetta(path.newSubPath("formula"), processor, Formula.class, getFormula());
		processor.processBasic(path.newSubPath("encodedDescription"), String.class, getEncodedDescription(), this);
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getCalculationDates());
		processor.processBasic(path.newSubPath("cashSettlement"), Boolean.class, getCashSettlement(), this);
		processRosetta(path.newSubPath("dividendsModel"), processor, DividendsModel.class, getDividendsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapAmountBuilder extends ReturnSwapAmount, LegAmount.LegAmountBuilder {
		DividendsModel.DividendsModelBuilder getOrCreateDividendsModel();
		DividendsModel.DividendsModelBuilder getDividendsModel();
		ReturnSwapAmount.ReturnSwapAmountBuilder setCurrencyAndDeterminationMethodModel(CurrencyAndDeterminationMethodModel currencyAndDeterminationMethodModel);
		ReturnSwapAmount.ReturnSwapAmountBuilder setReferenceAmount(ReferenceAmount referenceAmount);
		ReturnSwapAmount.ReturnSwapAmountBuilder setFormula(Formula formula);
		ReturnSwapAmount.ReturnSwapAmountBuilder setEncodedDescription(String encodedDescription);
		ReturnSwapAmount.ReturnSwapAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);
		ReturnSwapAmount.ReturnSwapAmountBuilder setCashSettlement(Boolean cashSettlement);
		ReturnSwapAmount.ReturnSwapAmountBuilder setDividendsModel(DividendsModel dividendsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currencyAndDeterminationMethodModel"), processor, CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder.class, getCurrencyAndDeterminationMethodModel());
			processRosetta(path.newSubPath("referenceAmount"), processor, ReferenceAmount.ReferenceAmountBuilder.class, getReferenceAmount());
			processRosetta(path.newSubPath("formula"), processor, Formula.FormulaBuilder.class, getFormula());
			processor.processBasic(path.newSubPath("encodedDescription"), String.class, getEncodedDescription(), this);
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
			processor.processBasic(path.newSubPath("cashSettlement"), Boolean.class, getCashSettlement(), this);
			processRosetta(path.newSubPath("dividendsModel"), processor, DividendsModel.DividendsModelBuilder.class, getDividendsModel());
		}
		

		ReturnSwapAmount.ReturnSwapAmountBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapAmount  ***********************/
	class ReturnSwapAmountImpl extends LegAmount.LegAmountImpl implements ReturnSwapAmount {
		private final Boolean cashSettlement;
		private final DividendsModel dividendsModel;
		
		protected ReturnSwapAmountImpl(ReturnSwapAmount.ReturnSwapAmountBuilder builder) {
			super(builder);
			this.cashSettlement = builder.getCashSettlement();
			this.dividendsModel = ofNullable(builder.getDividendsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public Boolean getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("dividendsModel")
		public DividendsModel getDividendsModel() {
			return dividendsModel;
		}
		
		@Override
		public ReturnSwapAmount build() {
			return this;
		}
		
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder toBuilder() {
			ReturnSwapAmount.ReturnSwapAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapAmount.ReturnSwapAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getDividendsModel()).ifPresent(builder::setDividendsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapAmount _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(dividendsModel, _that.getDividendsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (dividendsModel != null ? dividendsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapAmount {" +
				"cashSettlement=" + this.cashSettlement + ", " +
				"dividendsModel=" + this.dividendsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwapAmount  ***********************/
	class ReturnSwapAmountBuilderImpl extends LegAmount.LegAmountBuilderImpl  implements ReturnSwapAmount.ReturnSwapAmountBuilder {
	
		protected Boolean cashSettlement;
		protected DividendsModel.DividendsModelBuilder dividendsModel;
	
		public ReturnSwapAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("cashSettlement")
		public Boolean getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("dividendsModel")
		public DividendsModel.DividendsModelBuilder getDividendsModel() {
			return dividendsModel;
		}
		
		@Override
		public DividendsModel.DividendsModelBuilder getOrCreateDividendsModel() {
			DividendsModel.DividendsModelBuilder result;
			if (dividendsModel!=null) {
				result = dividendsModel;
			}
			else {
				result = dividendsModel = DividendsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currencyAndDeterminationMethodModel")
		public ReturnSwapAmount.ReturnSwapAmountBuilder setCurrencyAndDeterminationMethodModel(CurrencyAndDeterminationMethodModel currencyAndDeterminationMethodModel) {
			this.currencyAndDeterminationMethodModel = currencyAndDeterminationMethodModel==null?null:currencyAndDeterminationMethodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceAmount")
		public ReturnSwapAmount.ReturnSwapAmountBuilder setReferenceAmount(ReferenceAmount referenceAmount) {
			this.referenceAmount = referenceAmount==null?null:referenceAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("formula")
		public ReturnSwapAmount.ReturnSwapAmountBuilder setFormula(Formula formula) {
			this.formula = formula==null?null:formula.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("encodedDescription")
		public ReturnSwapAmount.ReturnSwapAmountBuilder setEncodedDescription(String encodedDescription) {
			this.encodedDescription = encodedDescription==null?null:encodedDescription;
			return this;
		}
		@Override
		@RosettaAttribute("calculationDates")
		public ReturnSwapAmount.ReturnSwapAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates) {
			this.calculationDates = calculationDates==null?null:calculationDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlement")
		public ReturnSwapAmount.ReturnSwapAmountBuilder setCashSettlement(Boolean cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement;
			return this;
		}
		@Override
		@RosettaAttribute("dividendsModel")
		public ReturnSwapAmount.ReturnSwapAmountBuilder setDividendsModel(DividendsModel dividendsModel) {
			this.dividendsModel = dividendsModel==null?null:dividendsModel.toBuilder();
			return this;
		}
		
		@Override
		public ReturnSwapAmount build() {
			return new ReturnSwapAmount.ReturnSwapAmountImpl(this);
		}
		
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder prune() {
			super.prune();
			if (dividendsModel!=null && !dividendsModel.prune().hasData()) dividendsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCashSettlement()!=null) return true;
			if (getDividendsModel()!=null && getDividendsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ReturnSwapAmount.ReturnSwapAmountBuilder o = (ReturnSwapAmount.ReturnSwapAmountBuilder) other;
			
			merger.mergeRosetta(getDividendsModel(), o.getDividendsModel(), this::setDividendsModel);
			
			merger.mergeBasic(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapAmount _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(dividendsModel, _that.getDividendsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (dividendsModel != null ? dividendsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapAmountBuilder {" +
				"cashSettlement=" + this.cashSettlement + ", " +
				"dividendsModel=" + this.dividendsModel +
			'}' + " " + super.toString();
		}
	}
}
