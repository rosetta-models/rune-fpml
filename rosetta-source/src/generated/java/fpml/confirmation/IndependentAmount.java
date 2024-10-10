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
import fpml.confirmation.IndependentAmount;
import fpml.confirmation.IndependentAmount.IndependentAmountBuilder;
import fpml.confirmation.IndependentAmount.IndependentAmountBuilderImpl;
import fpml.confirmation.IndependentAmount.IndependentAmountImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentDetail;
import fpml.confirmation.meta.IndependentAmountMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="IndependentAmount", builder=IndependentAmount.IndependentAmountBuilderImpl.class, version="${project.version}")
public interface IndependentAmount extends RosettaModelObject {

	IndependentAmountMeta metaData = new IndependentAmountMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * A container element allowing a schedule of payments associated with the Independent Amount.
	 */
	List<? extends PaymentDetail> getPaymentDetail();

	/*********************** Build Methods  ***********************/
	IndependentAmount build();
	
	IndependentAmount.IndependentAmountBuilder toBuilder();
	
	static IndependentAmount.IndependentAmountBuilder builder() {
		return new IndependentAmount.IndependentAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndependentAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndependentAmount> getType() {
		return IndependentAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("paymentDetail"), processor, PaymentDetail.class, getPaymentDetail());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndependentAmountBuilder extends IndependentAmount, RosettaModelObjectBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		PaymentDetail.PaymentDetailBuilder getOrCreatePaymentDetail(int _index);
		List<? extends PaymentDetail.PaymentDetailBuilder> getPaymentDetail();
		IndependentAmount.IndependentAmountBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail paymentDetail0);
		IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail paymentDetail1, int _idx);
		IndependentAmount.IndependentAmountBuilder addPaymentDetail(List<? extends PaymentDetail> paymentDetail2);
		IndependentAmount.IndependentAmountBuilder setPaymentDetail(List<? extends PaymentDetail> paymentDetail3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("paymentDetail"), processor, PaymentDetail.PaymentDetailBuilder.class, getPaymentDetail());
		}
		

		IndependentAmount.IndependentAmountBuilder prune();
	}

	/*********************** Immutable Implementation of IndependentAmount  ***********************/
	class IndependentAmountImpl implements IndependentAmount {
		private final PayerReceiverModel payerReceiverModel;
		private final List<? extends PaymentDetail> paymentDetail;
		
		protected IndependentAmountImpl(IndependentAmount.IndependentAmountBuilder builder) {
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.paymentDetail = ofNullable(builder.getPaymentDetail()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("paymentDetail")
		public List<? extends PaymentDetail> getPaymentDetail() {
			return paymentDetail;
		}
		
		@Override
		public IndependentAmount build() {
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder toBuilder() {
			IndependentAmount.IndependentAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndependentAmount.IndependentAmountBuilder builder) {
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getPaymentDetail()).ifPresent(builder::setPaymentDetail);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndependentAmount _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!ListEquals.listEquals(paymentDetail, _that.getPaymentDetail())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (paymentDetail != null ? paymentDetail.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndependentAmount {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"paymentDetail=" + this.paymentDetail +
			'}';
		}
	}

	/*********************** Builder Implementation of IndependentAmount  ***********************/
	class IndependentAmountBuilderImpl implements IndependentAmount.IndependentAmountBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected List<PaymentDetail.PaymentDetailBuilder> paymentDetail = new ArrayList<>();
	
		public IndependentAmountBuilderImpl() {
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
		@RosettaAttribute("paymentDetail")
		public List<? extends PaymentDetail.PaymentDetailBuilder> getPaymentDetail() {
			return paymentDetail;
		}
		
		public PaymentDetail.PaymentDetailBuilder getOrCreatePaymentDetail(int _index) {
		
			if (paymentDetail==null) {
				this.paymentDetail = new ArrayList<>();
			}
			PaymentDetail.PaymentDetailBuilder result;
			return getIndex(paymentDetail, _index, () -> {
						PaymentDetail.PaymentDetailBuilder newPaymentDetail = PaymentDetail.builder();
						return newPaymentDetail;
					});
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public IndependentAmount.IndependentAmountBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		public IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail paymentDetail) {
			if (paymentDetail!=null) this.paymentDetail.add(paymentDetail.toBuilder());
			return this;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder addPaymentDetail(PaymentDetail paymentDetail, int _idx) {
			getIndex(this.paymentDetail, _idx, () -> paymentDetail.toBuilder());
			return this;
		}
		@Override 
		public IndependentAmount.IndependentAmountBuilder addPaymentDetail(List<? extends PaymentDetail> paymentDetails) {
			if (paymentDetails != null) {
				for (PaymentDetail toAdd : paymentDetails) {
					this.paymentDetail.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("paymentDetail")
		public IndependentAmount.IndependentAmountBuilder setPaymentDetail(List<? extends PaymentDetail> paymentDetails) {
			if (paymentDetails == null)  {
				this.paymentDetail = new ArrayList<>();
			}
			else {
				this.paymentDetail = paymentDetails.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public IndependentAmount build() {
			return new IndependentAmount.IndependentAmountImpl(this);
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndependentAmount.IndependentAmountBuilder prune() {
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			paymentDetail = paymentDetail.stream().filter(b->b!=null).<PaymentDetail.PaymentDetailBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getPaymentDetail()!=null && getPaymentDetail().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndependentAmount.IndependentAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndependentAmount.IndependentAmountBuilder o = (IndependentAmount.IndependentAmountBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getPaymentDetail(), o.getPaymentDetail(), this::getOrCreatePaymentDetail);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndependentAmount _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!ListEquals.listEquals(paymentDetail, _that.getPaymentDetail())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (paymentDetail != null ? paymentDetail.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndependentAmountBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"paymentDetail=" + this.paymentDetail +
			'}';
		}
	}
}
