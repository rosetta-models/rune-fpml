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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.CommodityPremium.CommodityPremiumBuilder;
import fpml.confirmation.CommodityPremium.CommodityPremiumBuilderImpl;
import fpml.confirmation.CommodityPremium.CommodityPremiumImpl;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentBuilder;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentBuilderImpl;
import fpml.confirmation.NonNegativePayment.NonNegativePaymentImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.CommodityPremiumMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The commodity option premium payable by the buyer to the seller.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPremium", builder=CommodityPremium.CommodityPremiumBuilderImpl.class, version="${project.version}")
public interface CommodityPremium extends NonNegativePayment {

	CommodityPremiumMeta metaData = new CommodityPremiumMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency amount of premium to be paid per Unit of the Total Notional Quantity.
	 */
	NonNegativeMoney getPremiumPerUnit();

	/*********************** Build Methods  ***********************/
	CommodityPremium build();
	
	CommodityPremium.CommodityPremiumBuilder toBuilder();
	
	static CommodityPremium.CommodityPremiumBuilder builder() {
		return new CommodityPremium.CommodityPremiumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPremium> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPremium> getType() {
		return CommodityPremium.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("premiumPerUnit"), processor, NonNegativeMoney.class, getPremiumPerUnit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPremiumBuilder extends CommodityPremium, NonNegativePayment.NonNegativePaymentBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePremiumPerUnit();
		NonNegativeMoney.NonNegativeMoneyBuilder getPremiumPerUnit();
		CommodityPremium.CommodityPremiumBuilder setId(String id);
		CommodityPremium.CommodityPremiumBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		CommodityPremium.CommodityPremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		CommodityPremium.CommodityPremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		CommodityPremium.CommodityPremiumBuilder setPremiumPerUnit(NonNegativeMoney premiumPerUnit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("premiumPerUnit"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPremiumPerUnit());
		}
		

		CommodityPremium.CommodityPremiumBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPremium  ***********************/
	class CommodityPremiumImpl extends NonNegativePayment.NonNegativePaymentImpl implements CommodityPremium {
		private final NonNegativeMoney premiumPerUnit;
		
		protected CommodityPremiumImpl(CommodityPremium.CommodityPremiumBuilder builder) {
			super(builder);
			this.premiumPerUnit = ofNullable(builder.getPremiumPerUnit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("premiumPerUnit")
		public NonNegativeMoney getPremiumPerUnit() {
			return premiumPerUnit;
		}
		
		@Override
		public CommodityPremium build() {
			return this;
		}
		
		@Override
		public CommodityPremium.CommodityPremiumBuilder toBuilder() {
			CommodityPremium.CommodityPremiumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPremium.CommodityPremiumBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPremiumPerUnit()).ifPresent(builder::setPremiumPerUnit);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPremium _that = getType().cast(o);
		
			if (!Objects.equals(premiumPerUnit, _that.getPremiumPerUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premiumPerUnit != null ? premiumPerUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPremium {" +
				"premiumPerUnit=" + this.premiumPerUnit +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPremium  ***********************/
	class CommodityPremiumBuilderImpl extends NonNegativePayment.NonNegativePaymentBuilderImpl  implements CommodityPremium.CommodityPremiumBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder premiumPerUnit;
	
		public CommodityPremiumBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("premiumPerUnit")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPremiumPerUnit() {
			return premiumPerUnit;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePremiumPerUnit() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (premiumPerUnit!=null) {
				result = premiumPerUnit;
			}
			else {
				result = premiumPerUnit = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityPremium.CommodityPremiumBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public CommodityPremium.CommodityPremiumBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDate")
		public CommodityPremium.CommodityPremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentAmount")
		public CommodityPremium.CommodityPremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount) {
			this.paymentAmount = paymentAmount==null?null:paymentAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("premiumPerUnit")
		public CommodityPremium.CommodityPremiumBuilder setPremiumPerUnit(NonNegativeMoney premiumPerUnit) {
			this.premiumPerUnit = premiumPerUnit==null?null:premiumPerUnit.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPremium build() {
			return new CommodityPremium.CommodityPremiumImpl(this);
		}
		
		@Override
		public CommodityPremium.CommodityPremiumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPremium.CommodityPremiumBuilder prune() {
			super.prune();
			if (premiumPerUnit!=null && !premiumPerUnit.prune().hasData()) premiumPerUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPremiumPerUnit()!=null && getPremiumPerUnit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPremium.CommodityPremiumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityPremium.CommodityPremiumBuilder o = (CommodityPremium.CommodityPremiumBuilder) other;
			
			merger.mergeRosetta(getPremiumPerUnit(), o.getPremiumPerUnit(), this::setPremiumPerUnit);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPremium _that = getType().cast(o);
		
			if (!Objects.equals(premiumPerUnit, _that.getPremiumPerUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premiumPerUnit != null ? premiumPerUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPremiumBuilder {" +
				"premiumPerUnit=" + this.premiumPerUnit +
			'}' + " " + super.toString();
		}
	}
}
