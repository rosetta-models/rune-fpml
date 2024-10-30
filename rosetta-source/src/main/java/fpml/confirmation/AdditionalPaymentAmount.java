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
import fpml.confirmation.AdditionalPaymentAmount;
import fpml.confirmation.AdditionalPaymentAmount.AdditionalPaymentAmountBuilder;
import fpml.confirmation.AdditionalPaymentAmount.AdditionalPaymentAmountBuilderImpl;
import fpml.confirmation.AdditionalPaymentAmount.AdditionalPaymentAmountImpl;
import fpml.confirmation.Formula;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.AdditionalPaymentAmountMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the amount of the fee along with, when applicable, the formula that supports its determination.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AdditionalPaymentAmount", builder=AdditionalPaymentAmount.AdditionalPaymentAmountBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AdditionalPaymentAmount extends RosettaModelObject {

	AdditionalPaymentAmountMeta metaData = new AdditionalPaymentAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency amount of the payment.
	 */
	NonNegativeMoney getPaymentAmount();
	/**
	 * Specifies a formula, with its description and components.
	 */
	Formula getFormula();

	/*********************** Build Methods  ***********************/
	AdditionalPaymentAmount build();
	
	AdditionalPaymentAmount.AdditionalPaymentAmountBuilder toBuilder();
	
	static AdditionalPaymentAmount.AdditionalPaymentAmountBuilder builder() {
		return new AdditionalPaymentAmount.AdditionalPaymentAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdditionalPaymentAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdditionalPaymentAmount> getType() {
		return AdditionalPaymentAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("formula"), processor, Formula.class, getFormula());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdditionalPaymentAmountBuilder extends AdditionalPaymentAmount, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount();
		Formula.FormulaBuilder getOrCreateFormula();
		Formula.FormulaBuilder getFormula();
		AdditionalPaymentAmount.AdditionalPaymentAmountBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		AdditionalPaymentAmount.AdditionalPaymentAmountBuilder setFormula(Formula formula);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("formula"), processor, Formula.FormulaBuilder.class, getFormula());
		}
		

		AdditionalPaymentAmount.AdditionalPaymentAmountBuilder prune();
	}

	/*********************** Immutable Implementation of AdditionalPaymentAmount  ***********************/
	class AdditionalPaymentAmountImpl implements AdditionalPaymentAmount {
		private final NonNegativeMoney paymentAmount;
		private final Formula formula;
		
		protected AdditionalPaymentAmountImpl(AdditionalPaymentAmount.AdditionalPaymentAmountBuilder builder) {
			this.paymentAmount = ofNullable(builder.getPaymentAmount()).map(f->f.build()).orElse(null);
			this.formula = ofNullable(builder.getFormula()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentAmount")
		public NonNegativeMoney getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		@RosettaAttribute("formula")
		public Formula getFormula() {
			return formula;
		}
		
		@Override
		public AdditionalPaymentAmount build() {
			return this;
		}
		
		@Override
		public AdditionalPaymentAmount.AdditionalPaymentAmountBuilder toBuilder() {
			AdditionalPaymentAmount.AdditionalPaymentAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalPaymentAmount.AdditionalPaymentAmountBuilder builder) {
			ofNullable(getPaymentAmount()).ifPresent(builder::setPaymentAmount);
			ofNullable(getFormula()).ifPresent(builder::setFormula);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalPaymentAmount _that = getType().cast(o);
		
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalPaymentAmount {" +
				"paymentAmount=" + this.paymentAmount + ", " +
				"formula=" + this.formula +
			'}';
		}
	}

	/*********************** Builder Implementation of AdditionalPaymentAmount  ***********************/
	class AdditionalPaymentAmountBuilderImpl implements AdditionalPaymentAmount.AdditionalPaymentAmountBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder paymentAmount;
		protected Formula.FormulaBuilder formula;
	
		public AdditionalPaymentAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paymentAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPaymentAmount() {
			return paymentAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePaymentAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (paymentAmount!=null) {
				result = paymentAmount;
			}
			else {
				result = paymentAmount = NonNegativeMoney.builder();
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
		@RosettaAttribute("paymentAmount")
		public AdditionalPaymentAmount.AdditionalPaymentAmountBuilder setPaymentAmount(NonNegativeMoney paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("formula")
		public AdditionalPaymentAmount.AdditionalPaymentAmountBuilder setFormula(Formula formula) {
			this.formula = formula==null?null:formula.toBuilder();
			return this;
		}
		
		@Override
		public AdditionalPaymentAmount build() {
			return new AdditionalPaymentAmount.AdditionalPaymentAmountImpl(this);
		}
		
		@Override
		public AdditionalPaymentAmount.AdditionalPaymentAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalPaymentAmount.AdditionalPaymentAmountBuilder prune() {
			if (paymentAmount!=null && !paymentAmount.prune().hasData()) paymentAmount = null;
			if (formula!=null && !formula.prune().hasData()) formula = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentAmount()!=null && getPaymentAmount().hasData()) return true;
			if (getFormula()!=null && getFormula().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalPaymentAmount.AdditionalPaymentAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalPaymentAmount.AdditionalPaymentAmountBuilder o = (AdditionalPaymentAmount.AdditionalPaymentAmountBuilder) other;
			
			merger.mergeRosetta(getPaymentAmount(), o.getPaymentAmount(), this::setPaymentAmount);
			merger.mergeRosetta(getFormula(), o.getFormula(), this::setFormula);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalPaymentAmount _that = getType().cast(o);
		
			if (!Objects.equals(paymentAmount, _that.getPaymentAmount())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalPaymentAmountBuilder {" +
				"paymentAmount=" + this.paymentAmount + ", " +
				"formula=" + this.formula +
			'}';
		}
	}
}
