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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AbstractLoanAllocationPaymentNotification;
import fpml.confirmation.AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder;
import fpml.confirmation.AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationImpl;
import fpml.confirmation.AbstractLoanTradingNotification;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.LoanAllocationPayment;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AbstractLoanAllocationPaymentNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An underlying abstract structure for all syndicated loan servicing notifications; the wrapper for loan events which occur through the life-cycle of a deal.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLoanAllocationPaymentNotification", builder=AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilderImpl.class, version="${project.version}")
public interface AbstractLoanAllocationPaymentNotification extends AbstractLoanTradingNotification {

	AbstractLoanAllocationPaymentNotificationMeta metaData = new AbstractLoanAllocationPaymentNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The payments/wiring instructions associated with all embedded loan events.
	 */
	List<? extends LoanAllocationPayment> getPayment();

	/*********************** Build Methods  ***********************/
	AbstractLoanAllocationPaymentNotification build();
	
	AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder toBuilder();
	
	static AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder builder() {
		return new AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanAllocationPaymentNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanAllocationPaymentNotification> getType() {
		return AbstractLoanAllocationPaymentNotification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processor.processBasic(path.newSubPath("noticeDate"), Date.class, getNoticeDate(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.class, getRole());
		processRosetta(path.newSubPath("payment"), processor, LoanAllocationPayment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanAllocationPaymentNotificationBuilder extends AbstractLoanAllocationPaymentNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanAllocationPayment.LoanAllocationPaymentBuilder getOrCreatePayment(int _index);
		List<? extends LoanAllocationPayment.LoanAllocationPaymentBuilder> getPayment();
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setExpectedBuild(Integer expectedBuild);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setActualBuild(Integer actualBuild);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setHeader(RequestMessageHeader header);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setValidationModel(ValidationModel validationModel);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setIsCorrection(Boolean isCorrection);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setNoticeDate(Date noticeDate);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setPartyReference(PartyReference partyReference);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setRole(LoanTradingPartyRole role);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder addPayment(LoanAllocationPayment payment0);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder addPayment(LoanAllocationPayment payment1, int _idx);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder addPayment(List<? extends LoanAllocationPayment> payment2);
		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setPayment(List<? extends LoanAllocationPayment> payment3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("noticeDate"), Date.class, getNoticeDate(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.LoanTradingPartyRoleBuilder.class, getRole());
			processRosetta(path.newSubPath("payment"), processor, LoanAllocationPayment.LoanAllocationPaymentBuilder.class, getPayment());
		}
		

		AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanAllocationPaymentNotification  ***********************/
	class AbstractLoanAllocationPaymentNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements AbstractLoanAllocationPaymentNotification {
		private final List<? extends LoanAllocationPayment> payment;
		
		protected AbstractLoanAllocationPaymentNotificationImpl(AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder builder) {
			super(builder);
			this.payment = ofNullable(builder.getPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payment")
		public List<? extends LoanAllocationPayment> getPayment() {
			return payment;
		}
		
		@Override
		public AbstractLoanAllocationPaymentNotification build() {
			return this;
		}
		
		@Override
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder toBuilder() {
			AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationPaymentNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationPaymentNotification {" +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanAllocationPaymentNotification  ***********************/
	class AbstractLoanAllocationPaymentNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder {
	
		protected List<LoanAllocationPayment.LoanAllocationPaymentBuilder> payment = new ArrayList<>();
	
		public AbstractLoanAllocationPaymentNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payment")
		public List<? extends LoanAllocationPayment.LoanAllocationPaymentBuilder> getPayment() {
			return payment;
		}
		
		public LoanAllocationPayment.LoanAllocationPaymentBuilder getOrCreatePayment(int _index) {
		
			if (payment==null) {
				this.payment = new ArrayList<>();
			}
			LoanAllocationPayment.LoanAllocationPaymentBuilder result;
			return getIndex(payment, _index, () -> {
						LoanAllocationPayment.LoanAllocationPaymentBuilder newPayment = LoanAllocationPayment.builder();
						return newPayment;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder addPayment(LoanAllocationPayment payment) {
			if (payment!=null) this.payment.add(payment.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder addPayment(LoanAllocationPayment payment, int _idx) {
			getIndex(this.payment, _idx, () -> payment.toBuilder());
			return this;
		}
		@Override 
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder addPayment(List<? extends LoanAllocationPayment> payments) {
			if (payments != null) {
				for (LoanAllocationPayment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("payment")
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder setPayment(List<? extends LoanAllocationPayment> payments) {
			if (payments == null)  {
				this.payment = new ArrayList<>();
			}
			else {
				this.payment = payments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AbstractLoanAllocationPaymentNotification build() {
			return new AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationImpl(this);
		}
		
		@Override
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder prune() {
			super.prune();
			payment = payment.stream().filter(b->b!=null).<LoanAllocationPayment.LoanAllocationPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayment()!=null && getPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder o = (AbstractLoanAllocationPaymentNotification.AbstractLoanAllocationPaymentNotificationBuilder) other;
			
			merger.mergeRosetta(getPayment(), o.getPayment(), this::getOrCreatePayment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationPaymentNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationPaymentNotificationBuilder {" +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}
}
