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
import fpml.confirmation.AbstractServicingNotification;
import fpml.confirmation.AbstractServicingNotification.AbstractServicingNotificationBuilder;
import fpml.confirmation.AbstractServicingNotification.AbstractServicingNotificationBuilderImpl;
import fpml.confirmation.AbstractServicingNotification.AbstractServicingNotificationImpl;
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AbstractServicingNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type for all syndicated loan servicing notifications; the wrapper for loan events which occur through the life-cycle of a deal.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractServicingNotification", builder=AbstractServicingNotification.AbstractServicingNotificationBuilderImpl.class, version="${project.version}")
public interface AbstractServicingNotification extends CorrectableRequestMessage {

	AbstractServicingNotificationMeta metaData = new AbstractServicingNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The business date on which the notice is valid (and was communicated).
	 */
	Date getNoticeDate();
	/**
	 * Indicates whether the embedded business event is &#39;global&#39;, i.e. NOT lender specific.
	 */
	Boolean getIsGlobalOnly();
	/**
	 * The payments/wiring instructions associated with all embedded loan events.
	 */
	List<? extends EventPayment> getEventPayment();

	/*********************** Build Methods  ***********************/
	AbstractServicingNotification build();
	
	AbstractServicingNotification.AbstractServicingNotificationBuilder toBuilder();
	
	static AbstractServicingNotification.AbstractServicingNotificationBuilder builder() {
		return new AbstractServicingNotification.AbstractServicingNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractServicingNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractServicingNotification> getType() {
		return AbstractServicingNotification.class;
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
		processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
		processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.class, getEventPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractServicingNotificationBuilder extends AbstractServicingNotification, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		EventPayment.EventPaymentBuilder getOrCreateEventPayment(int _index);
		List<? extends EventPayment.EventPaymentBuilder> getEventPayment();
		AbstractServicingNotification.AbstractServicingNotificationBuilder setExpectedBuild(Integer expectedBuild);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setActualBuild(Integer actualBuild);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setHeader(RequestMessageHeader header);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setValidationModel(ValidationModel validationModel);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setIsCorrection(Boolean isCorrection);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setNoticeDate(Date noticeDate);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(EventPayment eventPayment0);
		AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		AbstractServicingNotification.AbstractServicingNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);

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
			processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
			processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.EventPaymentBuilder.class, getEventPayment());
		}
		

		AbstractServicingNotification.AbstractServicingNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractServicingNotification  ***********************/
	class AbstractServicingNotificationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements AbstractServicingNotification {
		private final Date noticeDate;
		private final Boolean isGlobalOnly;
		private final List<? extends EventPayment> eventPayment;
		
		protected AbstractServicingNotificationImpl(AbstractServicingNotification.AbstractServicingNotificationBuilder builder) {
			super(builder);
			this.noticeDate = builder.getNoticeDate();
			this.isGlobalOnly = builder.getIsGlobalOnly();
			this.eventPayment = ofNullable(builder.getEventPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("noticeDate")
		public Date getNoticeDate() {
			return noticeDate;
		}
		
		@Override
		@RosettaAttribute("isGlobalOnly")
		public Boolean getIsGlobalOnly() {
			return isGlobalOnly;
		}
		
		@Override
		@RosettaAttribute("eventPayment")
		public List<? extends EventPayment> getEventPayment() {
			return eventPayment;
		}
		
		@Override
		public AbstractServicingNotification build() {
			return this;
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder toBuilder() {
			AbstractServicingNotification.AbstractServicingNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractServicingNotification.AbstractServicingNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNoticeDate()).ifPresent(builder::setNoticeDate);
			ofNullable(getIsGlobalOnly()).ifPresent(builder::setIsGlobalOnly);
			ofNullable(getEventPayment()).ifPresent(builder::setEventPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractServicingNotification _that = getType().cast(o);
		
			if (!Objects.equals(noticeDate, _that.getNoticeDate())) return false;
			if (!Objects.equals(isGlobalOnly, _that.getIsGlobalOnly())) return false;
			if (!ListEquals.listEquals(eventPayment, _that.getEventPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (noticeDate != null ? noticeDate.hashCode() : 0);
			_result = 31 * _result + (isGlobalOnly != null ? isGlobalOnly.hashCode() : 0);
			_result = 31 * _result + (eventPayment != null ? eventPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractServicingNotification {" +
				"noticeDate=" + this.noticeDate + ", " +
				"isGlobalOnly=" + this.isGlobalOnly + ", " +
				"eventPayment=" + this.eventPayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractServicingNotification  ***********************/
	class AbstractServicingNotificationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements AbstractServicingNotification.AbstractServicingNotificationBuilder {
	
		protected Date noticeDate;
		protected Boolean isGlobalOnly;
		protected List<EventPayment.EventPaymentBuilder> eventPayment = new ArrayList<>();
	
		public AbstractServicingNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("noticeDate")
		public Date getNoticeDate() {
			return noticeDate;
		}
		
		@Override
		@RosettaAttribute("isGlobalOnly")
		public Boolean getIsGlobalOnly() {
			return isGlobalOnly;
		}
		
		@Override
		@RosettaAttribute("eventPayment")
		public List<? extends EventPayment.EventPaymentBuilder> getEventPayment() {
			return eventPayment;
		}
		
		@Override
		public EventPayment.EventPaymentBuilder getOrCreateEventPayment(int _index) {
		
			if (eventPayment==null) {
				this.eventPayment = new ArrayList<>();
			}
			EventPayment.EventPaymentBuilder result;
			return getIndex(eventPayment, _index, () -> {
						EventPayment.EventPaymentBuilder newEventPayment = EventPayment.builder();
						return newEventPayment;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		@RosettaAttribute("eventPayment")
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public AbstractServicingNotification.AbstractServicingNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AbstractServicingNotification.AbstractServicingNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments == null)  {
				this.eventPayment = new ArrayList<>();
			}
			else {
				this.eventPayment = eventPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AbstractServicingNotification build() {
			return new AbstractServicingNotification.AbstractServicingNotificationImpl(this);
		}
		
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder prune() {
			super.prune();
			eventPayment = eventPayment.stream().filter(b->b!=null).<EventPayment.EventPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNoticeDate()!=null) return true;
			if (getIsGlobalOnly()!=null) return true;
			if (getEventPayment()!=null && getEventPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractServicingNotification.AbstractServicingNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractServicingNotification.AbstractServicingNotificationBuilder o = (AbstractServicingNotification.AbstractServicingNotificationBuilder) other;
			
			merger.mergeRosetta(getEventPayment(), o.getEventPayment(), this::getOrCreateEventPayment);
			
			merger.mergeBasic(getNoticeDate(), o.getNoticeDate(), this::setNoticeDate);
			merger.mergeBasic(getIsGlobalOnly(), o.getIsGlobalOnly(), this::setIsGlobalOnly);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractServicingNotification _that = getType().cast(o);
		
			if (!Objects.equals(noticeDate, _that.getNoticeDate())) return false;
			if (!Objects.equals(isGlobalOnly, _that.getIsGlobalOnly())) return false;
			if (!ListEquals.listEquals(eventPayment, _that.getEventPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (noticeDate != null ? noticeDate.hashCode() : 0);
			_result = 31 * _result + (isGlobalOnly != null ? isGlobalOnly.hashCode() : 0);
			_result = 31 * _result + (eventPayment != null ? eventPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractServicingNotificationBuilder {" +
				"noticeDate=" + this.noticeDate + ", " +
				"isGlobalOnly=" + this.isGlobalOnly + ", " +
				"eventPayment=" + this.eventPayment +
			'}' + " " + super.toString();
		}
	}
}
