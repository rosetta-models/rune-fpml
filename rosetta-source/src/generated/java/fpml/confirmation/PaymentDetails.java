package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.GrossCashflow;
import fpml.confirmation.PaymentDetails;
import fpml.confirmation.PaymentDetails.PaymentDetailsBuilder;
import fpml.confirmation.PaymentDetails.PaymentDetailsBuilderImpl;
import fpml.confirmation.PaymentDetails.PaymentDetailsImpl;
import fpml.confirmation.PaymentReference;
import fpml.confirmation.SettlementInformation;
import fpml.confirmation.meta.PaymentDetailsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Details on the referenced payment. e.g. Its cashflow components, settlement details.
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentDetails", builder=PaymentDetails.PaymentDetailsBuilderImpl.class, version="${project.version}")
public interface PaymentDetails extends RosettaModelObject {

	PaymentDetailsMeta metaData = new PaymentDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The reference to the identified payment strucutre.
	 */
	PaymentReference getPaymentReference();
	/**
	 * Payment details of this cash flow component, including currency, amount and payer/payee.
	 */
	List<? extends GrossCashflow> getGrossCashflow();
	/**
	 * The information required to settle a currency payment.
	 */
	SettlementInformation getSettlementInformation();

	/*********************** Build Methods  ***********************/
	PaymentDetails build();
	
	PaymentDetails.PaymentDetailsBuilder toBuilder();
	
	static PaymentDetails.PaymentDetailsBuilder builder() {
		return new PaymentDetails.PaymentDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentDetails> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PaymentDetails> getType() {
		return PaymentDetails.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("paymentReference"), processor, PaymentReference.class, getPaymentReference());
		processRosetta(path.newSubPath("grossCashflow"), processor, GrossCashflow.class, getGrossCashflow());
		processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.class, getSettlementInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentDetailsBuilder extends PaymentDetails, RosettaModelObjectBuilder {
		PaymentReference.PaymentReferenceBuilder getOrCreatePaymentReference();
		PaymentReference.PaymentReferenceBuilder getPaymentReference();
		GrossCashflow.GrossCashflowBuilder getOrCreateGrossCashflow(int _index);
		List<? extends GrossCashflow.GrossCashflowBuilder> getGrossCashflow();
		SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation();
		SettlementInformation.SettlementInformationBuilder getSettlementInformation();
		PaymentDetails.PaymentDetailsBuilder setPaymentReference(PaymentReference paymentReference);
		PaymentDetails.PaymentDetailsBuilder addGrossCashflow(GrossCashflow grossCashflow0);
		PaymentDetails.PaymentDetailsBuilder addGrossCashflow(GrossCashflow grossCashflow1, int _idx);
		PaymentDetails.PaymentDetailsBuilder addGrossCashflow(List<? extends GrossCashflow> grossCashflow2);
		PaymentDetails.PaymentDetailsBuilder setGrossCashflow(List<? extends GrossCashflow> grossCashflow3);
		PaymentDetails.PaymentDetailsBuilder setSettlementInformation(SettlementInformation settlementInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("paymentReference"), processor, PaymentReference.PaymentReferenceBuilder.class, getPaymentReference());
			processRosetta(path.newSubPath("grossCashflow"), processor, GrossCashflow.GrossCashflowBuilder.class, getGrossCashflow());
			processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.SettlementInformationBuilder.class, getSettlementInformation());
		}
		

		PaymentDetails.PaymentDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentDetails  ***********************/
	class PaymentDetailsImpl implements PaymentDetails {
		private final PaymentReference paymentReference;
		private final List<? extends GrossCashflow> grossCashflow;
		private final SettlementInformation settlementInformation;
		
		protected PaymentDetailsImpl(PaymentDetails.PaymentDetailsBuilder builder) {
			this.paymentReference = ofNullable(builder.getPaymentReference()).map(f->f.build()).orElse(null);
			this.grossCashflow = ofNullable(builder.getGrossCashflow()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementInformation = ofNullable(builder.getSettlementInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentReference")
		public PaymentReference getPaymentReference() {
			return paymentReference;
		}
		
		@Override
		@RosettaAttribute("grossCashflow")
		public List<? extends GrossCashflow> getGrossCashflow() {
			return grossCashflow;
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		public SettlementInformation getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		public PaymentDetails build() {
			return this;
		}
		
		@Override
		public PaymentDetails.PaymentDetailsBuilder toBuilder() {
			PaymentDetails.PaymentDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentDetails.PaymentDetailsBuilder builder) {
			ofNullable(getPaymentReference()).ifPresent(builder::setPaymentReference);
			ofNullable(getGrossCashflow()).ifPresent(builder::setGrossCashflow);
			ofNullable(getSettlementInformation()).ifPresent(builder::setSettlementInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDetails _that = getType().cast(o);
		
			if (!Objects.equals(paymentReference, _that.getPaymentReference())) return false;
			if (!ListEquals.listEquals(grossCashflow, _that.getGrossCashflow())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentReference != null ? paymentReference.hashCode() : 0);
			_result = 31 * _result + (grossCashflow != null ? grossCashflow.hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDetails {" +
				"paymentReference=" + this.paymentReference + ", " +
				"grossCashflow=" + this.grossCashflow + ", " +
				"settlementInformation=" + this.settlementInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentDetails  ***********************/
	class PaymentDetailsBuilderImpl implements PaymentDetails.PaymentDetailsBuilder {
	
		protected PaymentReference.PaymentReferenceBuilder paymentReference;
		protected List<GrossCashflow.GrossCashflowBuilder> grossCashflow = new ArrayList<>();
		protected SettlementInformation.SettlementInformationBuilder settlementInformation;
	
		public PaymentDetailsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paymentReference")
		public PaymentReference.PaymentReferenceBuilder getPaymentReference() {
			return paymentReference;
		}
		
		@Override
		public PaymentReference.PaymentReferenceBuilder getOrCreatePaymentReference() {
			PaymentReference.PaymentReferenceBuilder result;
			if (paymentReference!=null) {
				result = paymentReference;
			}
			else {
				result = paymentReference = PaymentReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("grossCashflow")
		public List<? extends GrossCashflow.GrossCashflowBuilder> getGrossCashflow() {
			return grossCashflow;
		}
		
		public GrossCashflow.GrossCashflowBuilder getOrCreateGrossCashflow(int _index) {
		
			if (grossCashflow==null) {
				this.grossCashflow = new ArrayList<>();
			}
			GrossCashflow.GrossCashflowBuilder result;
			return getIndex(grossCashflow, _index, () -> {
						GrossCashflow.GrossCashflowBuilder newGrossCashflow = GrossCashflow.builder();
						return newGrossCashflow;
					});
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		public SettlementInformation.SettlementInformationBuilder getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		public SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation() {
			SettlementInformation.SettlementInformationBuilder result;
			if (settlementInformation!=null) {
				result = settlementInformation;
			}
			else {
				result = settlementInformation = SettlementInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentReference")
		public PaymentDetails.PaymentDetailsBuilder setPaymentReference(PaymentReference paymentReference) {
			this.paymentReference = paymentReference==null?null:paymentReference.toBuilder();
			return this;
		}
		@Override
		public PaymentDetails.PaymentDetailsBuilder addGrossCashflow(GrossCashflow grossCashflow) {
			if (grossCashflow!=null) this.grossCashflow.add(grossCashflow.toBuilder());
			return this;
		}
		
		@Override
		public PaymentDetails.PaymentDetailsBuilder addGrossCashflow(GrossCashflow grossCashflow, int _idx) {
			getIndex(this.grossCashflow, _idx, () -> grossCashflow.toBuilder());
			return this;
		}
		@Override 
		public PaymentDetails.PaymentDetailsBuilder addGrossCashflow(List<? extends GrossCashflow> grossCashflows) {
			if (grossCashflows != null) {
				for (GrossCashflow toAdd : grossCashflows) {
					this.grossCashflow.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("grossCashflow")
		public PaymentDetails.PaymentDetailsBuilder setGrossCashflow(List<? extends GrossCashflow> grossCashflows) {
			if (grossCashflows == null)  {
				this.grossCashflow = new ArrayList<>();
			}
			else {
				this.grossCashflow = grossCashflows.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		public PaymentDetails.PaymentDetailsBuilder setSettlementInformation(SettlementInformation settlementInformation) {
			this.settlementInformation = settlementInformation==null?null:settlementInformation.toBuilder();
			return this;
		}
		
		@Override
		public PaymentDetails build() {
			return new PaymentDetails.PaymentDetailsImpl(this);
		}
		
		@Override
		public PaymentDetails.PaymentDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDetails.PaymentDetailsBuilder prune() {
			if (paymentReference!=null && !paymentReference.prune().hasData()) paymentReference = null;
			grossCashflow = grossCashflow.stream().filter(b->b!=null).<GrossCashflow.GrossCashflowBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (settlementInformation!=null && !settlementInformation.prune().hasData()) settlementInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentReference()!=null && getPaymentReference().hasData()) return true;
			if (getGrossCashflow()!=null && getGrossCashflow().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementInformation()!=null && getSettlementInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDetails.PaymentDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentDetails.PaymentDetailsBuilder o = (PaymentDetails.PaymentDetailsBuilder) other;
			
			merger.mergeRosetta(getPaymentReference(), o.getPaymentReference(), this::setPaymentReference);
			merger.mergeRosetta(getGrossCashflow(), o.getGrossCashflow(), this::getOrCreateGrossCashflow);
			merger.mergeRosetta(getSettlementInformation(), o.getSettlementInformation(), this::setSettlementInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentDetails _that = getType().cast(o);
		
			if (!Objects.equals(paymentReference, _that.getPaymentReference())) return false;
			if (!ListEquals.listEquals(grossCashflow, _that.getGrossCashflow())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentReference != null ? paymentReference.hashCode() : 0);
			_result = 31 * _result + (grossCashflow != null ? grossCashflow.hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDetailsBuilder {" +
				"paymentReference=" + this.paymentReference + ", " +
				"grossCashflow=" + this.grossCashflow + ", " +
				"settlementInformation=" + this.settlementInformation +
			'}';
		}
	}
}
