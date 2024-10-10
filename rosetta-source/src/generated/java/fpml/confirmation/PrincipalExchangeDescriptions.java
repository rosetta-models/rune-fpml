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
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PrincipalExchangeAmount;
import fpml.confirmation.PrincipalExchangeDescriptions;
import fpml.confirmation.PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder;
import fpml.confirmation.PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilderImpl;
import fpml.confirmation.PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsImpl;
import fpml.confirmation.meta.PrincipalExchangeDescriptionsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies each of the characteristics of the principal exchange cashflows, in terms of paying/receiving counterparties, amounts and dates.
 * @version ${project.version}
 */
@RosettaDataType(value="PrincipalExchangeDescriptions", builder=PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilderImpl.class, version="${project.version}")
public interface PrincipalExchangeDescriptions extends RosettaModelObject {

	PrincipalExchangeDescriptionsMeta metaData = new PrincipalExchangeDescriptionsMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * Specifies the principal echange amount, either by explicitly defining it, or by point to an amount defined somewhere else in the swap document.
	 */
	PrincipalExchangeAmount getPrincipalExchangeAmount();
	/**
	 * Date on which each of the principal exchanges will take place. This date is either explictly stated, or is defined by reference to another date in the swap document. In this latter case, it will typically refer to one other date of the equity leg: either the effective date (initial exchange), or the last payment date (final exchange).
	 */
	AdjustableOrRelativeDate getPrincipalExchangeDate();

	/*********************** Build Methods  ***********************/
	PrincipalExchangeDescriptions build();
	
	PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder toBuilder();
	
	static PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder builder() {
		return new PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrincipalExchangeDescriptions> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PrincipalExchangeDescriptions> getType() {
		return PrincipalExchangeDescriptions.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("principalExchangeAmount"), processor, PrincipalExchangeAmount.class, getPrincipalExchangeAmount());
		processRosetta(path.newSubPath("principalExchangeDate"), processor, AdjustableOrRelativeDate.class, getPrincipalExchangeDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrincipalExchangeDescriptionsBuilder extends PrincipalExchangeDescriptions, RosettaModelObjectBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder getOrCreatePrincipalExchangeAmount();
		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder getPrincipalExchangeAmount();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePrincipalExchangeDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPrincipalExchangeDate();
		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPrincipalExchangeAmount(PrincipalExchangeAmount principalExchangeAmount);
		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPrincipalExchangeDate(AdjustableOrRelativeDate principalExchangeDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("principalExchangeAmount"), processor, PrincipalExchangeAmount.PrincipalExchangeAmountBuilder.class, getPrincipalExchangeAmount());
			processRosetta(path.newSubPath("principalExchangeDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPrincipalExchangeDate());
		}
		

		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder prune();
	}

	/*********************** Immutable Implementation of PrincipalExchangeDescriptions  ***********************/
	class PrincipalExchangeDescriptionsImpl implements PrincipalExchangeDescriptions {
		private final PayerReceiverModel payerReceiverModel;
		private final PrincipalExchangeAmount principalExchangeAmount;
		private final AdjustableOrRelativeDate principalExchangeDate;
		
		protected PrincipalExchangeDescriptionsImpl(PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder builder) {
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.principalExchangeAmount = ofNullable(builder.getPrincipalExchangeAmount()).map(f->f.build()).orElse(null);
			this.principalExchangeDate = ofNullable(builder.getPrincipalExchangeDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("principalExchangeAmount")
		public PrincipalExchangeAmount getPrincipalExchangeAmount() {
			return principalExchangeAmount;
		}
		
		@Override
		@RosettaAttribute("principalExchangeDate")
		public AdjustableOrRelativeDate getPrincipalExchangeDate() {
			return principalExchangeDate;
		}
		
		@Override
		public PrincipalExchangeDescriptions build() {
			return this;
		}
		
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder toBuilder() {
			PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder builder) {
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getPrincipalExchangeAmount()).ifPresent(builder::setPrincipalExchangeAmount);
			ofNullable(getPrincipalExchangeDate()).ifPresent(builder::setPrincipalExchangeDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeDescriptions _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(principalExchangeAmount, _that.getPrincipalExchangeAmount())) return false;
			if (!Objects.equals(principalExchangeDate, _that.getPrincipalExchangeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (principalExchangeAmount != null ? principalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (principalExchangeDate != null ? principalExchangeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeDescriptions {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"principalExchangeAmount=" + this.principalExchangeAmount + ", " +
				"principalExchangeDate=" + this.principalExchangeDate +
			'}';
		}
	}

	/*********************** Builder Implementation of PrincipalExchangeDescriptions  ***********************/
	class PrincipalExchangeDescriptionsBuilderImpl implements PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected PrincipalExchangeAmount.PrincipalExchangeAmountBuilder principalExchangeAmount;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder principalExchangeDate;
	
		public PrincipalExchangeDescriptionsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel() {
			PayerReceiverModel.PayerReceiverModelBuilder result;
			if (payerReceiverModel!=null) {
				result = payerReceiverModel;
			}
			else {
				result = payerReceiverModel = PayerReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principalExchangeAmount")
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder getPrincipalExchangeAmount() {
			return principalExchangeAmount;
		}
		
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder getOrCreatePrincipalExchangeAmount() {
			PrincipalExchangeAmount.PrincipalExchangeAmountBuilder result;
			if (principalExchangeAmount!=null) {
				result = principalExchangeAmount;
			}
			else {
				result = principalExchangeAmount = PrincipalExchangeAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principalExchangeDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPrincipalExchangeDate() {
			return principalExchangeDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePrincipalExchangeDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (principalExchangeDate!=null) {
				result = principalExchangeDate;
			}
			else {
				result = principalExchangeDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("principalExchangeAmount")
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPrincipalExchangeAmount(PrincipalExchangeAmount principalExchangeAmount) {
			this.principalExchangeAmount = principalExchangeAmount==null?null:principalExchangeAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("principalExchangeDate")
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder setPrincipalExchangeDate(AdjustableOrRelativeDate principalExchangeDate) {
			this.principalExchangeDate = principalExchangeDate==null?null:principalExchangeDate.toBuilder();
			return this;
		}
		
		@Override
		public PrincipalExchangeDescriptions build() {
			return new PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsImpl(this);
		}
		
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder prune() {
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (principalExchangeAmount!=null && !principalExchangeAmount.prune().hasData()) principalExchangeAmount = null;
			if (principalExchangeDate!=null && !principalExchangeDate.prune().hasData()) principalExchangeDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getPrincipalExchangeAmount()!=null && getPrincipalExchangeAmount().hasData()) return true;
			if (getPrincipalExchangeDate()!=null && getPrincipalExchangeDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder o = (PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getPrincipalExchangeAmount(), o.getPrincipalExchangeAmount(), this::setPrincipalExchangeAmount);
			merger.mergeRosetta(getPrincipalExchangeDate(), o.getPrincipalExchangeDate(), this::setPrincipalExchangeDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeDescriptions _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(principalExchangeAmount, _that.getPrincipalExchangeAmount())) return false;
			if (!Objects.equals(principalExchangeDate, _that.getPrincipalExchangeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (principalExchangeAmount != null ? principalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (principalExchangeDate != null ? principalExchangeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeDescriptionsBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"principalExchangeAmount=" + this.principalExchangeAmount + ", " +
				"principalExchangeDate=" + this.principalExchangeDate +
			'}';
		}
	}
}
