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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AbstractFacilityNotification;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationBuilder;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl;
import fpml.confirmation.AbstractFacilityNotification.AbstractFacilityNotificationImpl;
import fpml.confirmation.AbstractServicingNotification;
import fpml.confirmation.AbstractServicingNotification.AbstractServicingNotificationBuilder;
import fpml.confirmation.AbstractServicingNotification.AbstractServicingNotificationBuilderImpl;
import fpml.confirmation.AbstractServicingNotification.AbstractServicingNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityPosition;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AbstractFacilityNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An extension of the AbstractServicingNotification which includes a reference to the facility to which embedded loan events apply. This abtract type should be used to &#39;wrap&#39; facility-level business events.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AbstractFacilityNotification", builder=AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AbstractFacilityNotification extends AbstractServicingNotification {

	AbstractFacilityNotificationMeta metaData = new AbstractFacilityNotificationMeta();

	/*********************** Getter Methods  ***********************/
	FacilityPosition getFacilityPosition();

	/*********************** Build Methods  ***********************/
	AbstractFacilityNotification build();
	
	AbstractFacilityNotification.AbstractFacilityNotificationBuilder toBuilder();
	
	static AbstractFacilityNotification.AbstractFacilityNotificationBuilder builder() {
		return new AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractFacilityNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractFacilityNotification> getType() {
		return AbstractFacilityNotification.class;
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
		processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.class, getFacilityPosition());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractFacilityNotificationBuilder extends AbstractFacilityNotification, AbstractServicingNotification.AbstractServicingNotificationBuilder {
		FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition();
		FacilityPosition.FacilityPositionBuilder getFacilityPosition();
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setExpectedBuild(Integer expectedBuild);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setActualBuild(Integer actualBuild);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setHeader(RequestMessageHeader header);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setValidationModel(ValidationModel validationModel);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setIsCorrection(Boolean isCorrection);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setNoticeDate(Date noticeDate);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(EventPayment eventPayment0);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		AbstractFacilityNotification.AbstractFacilityNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition);

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
			processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.FacilityPositionBuilder.class, getFacilityPosition());
		}
		

		AbstractFacilityNotification.AbstractFacilityNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractFacilityNotification  ***********************/
	class AbstractFacilityNotificationImpl extends AbstractServicingNotification.AbstractServicingNotificationImpl implements AbstractFacilityNotification {
		private final FacilityPosition facilityPosition;
		
		protected AbstractFacilityNotificationImpl(AbstractFacilityNotification.AbstractFacilityNotificationBuilder builder) {
			super(builder);
			this.facilityPosition = ofNullable(builder.getFacilityPosition()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityPosition")
		public FacilityPosition getFacilityPosition() {
			return facilityPosition;
		}
		
		@Override
		public AbstractFacilityNotification build() {
			return this;
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder toBuilder() {
			AbstractFacilityNotification.AbstractFacilityNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractFacilityNotification.AbstractFacilityNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityPosition()).ifPresent(builder::setFacilityPosition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityPosition, _that.getFacilityPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityPosition != null ? facilityPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityNotification {" +
				"facilityPosition=" + this.facilityPosition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractFacilityNotification  ***********************/
	class AbstractFacilityNotificationBuilderImpl extends AbstractServicingNotification.AbstractServicingNotificationBuilderImpl  implements AbstractFacilityNotification.AbstractFacilityNotificationBuilder {
	
		protected FacilityPosition.FacilityPositionBuilder facilityPosition;
	
		public AbstractFacilityNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityPosition")
		public FacilityPosition.FacilityPositionBuilder getFacilityPosition() {
			return facilityPosition;
		}
		
		@Override
		public FacilityPosition.FacilityPositionBuilder getOrCreateFacilityPosition() {
			FacilityPosition.FacilityPositionBuilder result;
			if (facilityPosition!=null) {
				result = facilityPosition;
			}
			else {
				result = facilityPosition = FacilityPosition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		@RosettaAttribute("eventPayment")
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		@RosettaAttribute("facilityPosition")
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition) {
			this.facilityPosition = facilityPosition==null?null:facilityPosition.toBuilder();
			return this;
		}
		
		@Override
		public AbstractFacilityNotification build() {
			return new AbstractFacilityNotification.AbstractFacilityNotificationImpl(this);
		}
		
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder prune() {
			super.prune();
			if (facilityPosition!=null && !facilityPosition.prune().hasData()) facilityPosition = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityPosition()!=null && getFacilityPosition().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityNotification.AbstractFacilityNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractFacilityNotification.AbstractFacilityNotificationBuilder o = (AbstractFacilityNotification.AbstractFacilityNotificationBuilder) other;
			
			merger.mergeRosetta(getFacilityPosition(), o.getFacilityPosition(), this::setFacilityPosition);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityPosition, _that.getFacilityPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityPosition != null ? facilityPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityNotificationBuilder {" +
				"facilityPosition=" + this.facilityPosition +
			'}' + " " + super.toString();
		}
	}
}
