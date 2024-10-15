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
import fpml.confirmation.Money;
import fpml.confirmation.PaymentDiscountingModel;
import fpml.confirmation.PaymentDiscountingModel.PaymentDiscountingModelBuilder;
import fpml.confirmation.PaymentDiscountingModel.PaymentDiscountingModelBuilderImpl;
import fpml.confirmation.PaymentDiscountingModel.PaymentDiscountingModelImpl;
import fpml.confirmation.meta.PaymentDiscountingModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group for representing the discounting elements that can be associated with a payment.
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentDiscountingModel", builder=PaymentDiscountingModel.PaymentDiscountingModelBuilderImpl.class, version="${project.version}")
public interface PaymentDiscountingModel extends RosettaModelObject {

	PaymentDiscountingModelMeta metaData = new PaymentDiscountingModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The value representing the discount factor used to calculate the present value of the cash flow.
	 */
	BigDecimal getDiscountFactor();
	/**
	 * The amount representing the present value of the forecast payment.
	 */
	Money getPresentValueAmount();

	/*********************** Build Methods  ***********************/
	PaymentDiscountingModel build();
	
	PaymentDiscountingModel.PaymentDiscountingModelBuilder toBuilder();
	
	static PaymentDiscountingModel.PaymentDiscountingModelBuilder builder() {
		return new PaymentDiscountingModel.PaymentDiscountingModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentDiscountingModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PaymentDiscountingModel> getType() {
		return PaymentDiscountingModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processRosetta(path.newSubPath("presentValueAmount"), processor, Money.class, getPresentValueAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentDiscountingModelBuilder extends PaymentDiscountingModel, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreatePresentValueAmount();
		Money.MoneyBuilder getPresentValueAmount();
		PaymentDiscountingModel.PaymentDiscountingModelBuilder setDiscountFactor(BigDecimal discountFactor);
		PaymentDiscountingModel.PaymentDiscountingModelBuilder setPresentValueAmount(Money presentValueAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processRosetta(path.newSubPath("presentValueAmount"), processor, Money.MoneyBuilder.class, getPresentValueAmount());
		}
		

		PaymentDiscountingModel.PaymentDiscountingModelBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentDiscountingModel  ***********************/
	class PaymentDiscountingModelImpl implements PaymentDiscountingModel {
		private final BigDecimal discountFactor;
		private final Money presentValueAmount;
		
		protected PaymentDiscountingModelImpl(PaymentDiscountingModel.PaymentDiscountingModelBuilder builder) {
			this.discountFactor = builder.getDiscountFactor();
			this.presentValueAmount = ofNullable(builder.getPresentValueAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("presentValueAmount")
		public Money getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		public PaymentDiscountingModel build() {
			return this;
		}
		
		@Override
		public PaymentDiscountingModel.PaymentDiscountingModelBuilder toBuilder() {
			PaymentDiscountingModel.PaymentDiscountingModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentDiscountingModel.PaymentDiscountingModelBuilder builder) {
			ofNullable(getDiscountFactor()).ifPresent(builder::setDiscountFactor);
			ofNullable(getPresentValueAmount()).ifPresent(builder::setPresentValueAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDiscountingModel _that = getType().cast(o);
		
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDiscountingModel {" +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValueAmount=" + this.presentValueAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentDiscountingModel  ***********************/
	class PaymentDiscountingModelBuilderImpl implements PaymentDiscountingModel.PaymentDiscountingModelBuilder {
	
		protected BigDecimal discountFactor;
		protected Money.MoneyBuilder presentValueAmount;
	
		public PaymentDiscountingModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("presentValueAmount")
		public Money.MoneyBuilder getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePresentValueAmount() {
			Money.MoneyBuilder result;
			if (presentValueAmount!=null) {
				result = presentValueAmount;
			}
			else {
				result = presentValueAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		public PaymentDiscountingModel.PaymentDiscountingModelBuilder setDiscountFactor(BigDecimal discountFactor) {
			this.discountFactor = discountFactor==null?null:discountFactor;
			return this;
		}
		@Override
		@RosettaAttribute("presentValueAmount")
		public PaymentDiscountingModel.PaymentDiscountingModelBuilder setPresentValueAmount(Money presentValueAmount) {
			this.presentValueAmount = presentValueAmount==null?null:presentValueAmount.toBuilder();
			return this;
		}
		
		@Override
		public PaymentDiscountingModel build() {
			return new PaymentDiscountingModel.PaymentDiscountingModelImpl(this);
		}
		
		@Override
		public PaymentDiscountingModel.PaymentDiscountingModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDiscountingModel.PaymentDiscountingModelBuilder prune() {
			if (presentValueAmount!=null && !presentValueAmount.prune().hasData()) presentValueAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDiscountFactor()!=null) return true;
			if (getPresentValueAmount()!=null && getPresentValueAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDiscountingModel.PaymentDiscountingModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentDiscountingModel.PaymentDiscountingModelBuilder o = (PaymentDiscountingModel.PaymentDiscountingModelBuilder) other;
			
			merger.mergeRosetta(getPresentValueAmount(), o.getPresentValueAmount(), this::setPresentValueAmount);
			
			merger.mergeBasic(getDiscountFactor(), o.getDiscountFactor(), this::setDiscountFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDiscountingModel _that = getType().cast(o);
		
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDiscountingModelBuilder {" +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValueAmount=" + this.presentValueAmount +
			'}';
		}
	}
}
