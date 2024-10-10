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
import fpml.confirmation.AbstractLoanTradePaymentNotification;
import fpml.confirmation.AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder;
import fpml.confirmation.AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationImpl;
import fpml.confirmation.AbstractLoanTradingNotification;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.LoanTradePayment;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AbstractLoanTradePaymentNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An underlying abstract structure for all syndicated loan servicing notifications; the wrapper for payment events which occur through the life-cycle of a loan trade.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLoanTradePaymentNotification", builder=AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilderImpl.class, version="${project.version}")
public interface AbstractLoanTradePaymentNotification extends AbstractLoanTradingNotification {

	AbstractLoanTradePaymentNotificationMeta metaData = new AbstractLoanTradePaymentNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The payments/wiring instructions associated with all embedded loan events.
	 */
	List<? extends LoanTradePayment> getPayment();

	/*********************** Build Methods  ***********************/
	AbstractLoanTradePaymentNotification build();
	
	AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder toBuilder();
	
	static AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder builder() {
		return new AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanTradePaymentNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanTradePaymentNotification> getType() {
		return AbstractLoanTradePaymentNotification.class;
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
		processRosetta(path.newSubPath("payment"), processor, LoanTradePayment.class, getPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanTradePaymentNotificationBuilder extends AbstractLoanTradePaymentNotification, AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilder {
		LoanTradePayment.LoanTradePaymentBuilder getOrCreatePayment(int _index);
		List<? extends LoanTradePayment.LoanTradePaymentBuilder> getPayment();
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setExpectedBuild(Integer expectedBuild);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setActualBuild(Integer actualBuild);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setHeader(RequestMessageHeader header);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setValidationModel(ValidationModel validationModel);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setIsCorrection(Boolean isCorrection);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setNoticeDate(Date noticeDate);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setPartyReference(PartyReference partyReference);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setRole(LoanTradingPartyRole role);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder addPayment(LoanTradePayment payment0);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder addPayment(LoanTradePayment payment1, int _idx);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder addPayment(List<? extends LoanTradePayment> payment2);
		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setPayment(List<? extends LoanTradePayment> payment3);

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
			processRosetta(path.newSubPath("payment"), processor, LoanTradePayment.LoanTradePaymentBuilder.class, getPayment());
		}
		

		AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanTradePaymentNotification  ***********************/
	class AbstractLoanTradePaymentNotificationImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationImpl implements AbstractLoanTradePaymentNotification {
		private final List<? extends LoanTradePayment> payment;
		
		protected AbstractLoanTradePaymentNotificationImpl(AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder builder) {
			super(builder);
			this.payment = ofNullable(builder.getPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payment")
		public List<? extends LoanTradePayment> getPayment() {
			return payment;
		}
		
		@Override
		public AbstractLoanTradePaymentNotification build() {
			return this;
		}
		
		@Override
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder toBuilder() {
			AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanTradePaymentNotification _that = getType().cast(o);
		
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
			return "AbstractLoanTradePaymentNotification {" +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanTradePaymentNotification  ***********************/
	class AbstractLoanTradePaymentNotificationBuilderImpl extends AbstractLoanTradingNotification.AbstractLoanTradingNotificationBuilderImpl  implements AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder {
	
		protected List<LoanTradePayment.LoanTradePaymentBuilder> payment = new ArrayList<>();
	
		public AbstractLoanTradePaymentNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payment")
		public List<? extends LoanTradePayment.LoanTradePaymentBuilder> getPayment() {
			return payment;
		}
		
		public LoanTradePayment.LoanTradePaymentBuilder getOrCreatePayment(int _index) {
		
			if (payment==null) {
				this.payment = new ArrayList<>();
			}
			LoanTradePayment.LoanTradePaymentBuilder result;
			return getIndex(payment, _index, () -> {
						LoanTradePayment.LoanTradePaymentBuilder newPayment = LoanTradePayment.builder();
						return newPayment;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("partyReference")
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setRole(LoanTradingPartyRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		@Override
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder addPayment(LoanTradePayment payment) {
			if (payment!=null) this.payment.add(payment.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder addPayment(LoanTradePayment payment, int _idx) {
			getIndex(this.payment, _idx, () -> payment.toBuilder());
			return this;
		}
		@Override 
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder addPayment(List<? extends LoanTradePayment> payments) {
			if (payments != null) {
				for (LoanTradePayment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("payment")
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder setPayment(List<? extends LoanTradePayment> payments) {
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
		public AbstractLoanTradePaymentNotification build() {
			return new AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationImpl(this);
		}
		
		@Override
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder prune() {
			super.prune();
			payment = payment.stream().filter(b->b!=null).<LoanTradePayment.LoanTradePaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
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
		public AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder o = (AbstractLoanTradePaymentNotification.AbstractLoanTradePaymentNotificationBuilder) other;
			
			merger.mergeRosetta(getPayment(), o.getPayment(), this::getOrCreatePayment);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanTradePaymentNotification _that = getType().cast(o);
		
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
			return "AbstractLoanTradePaymentNotificationBuilder {" +
				"payment=" + this.payment +
			'}' + " " + super.toString();
		}
	}
}
