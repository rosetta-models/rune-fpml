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
import fpml.confirmation.AbstractContractNotification;
import fpml.confirmation.AbstractContractNotification.AbstractContractNotificationBuilder;
import fpml.confirmation.AbstractContractNotification.AbstractContractNotificationBuilderImpl;
import fpml.confirmation.AbstractContractNotification.AbstractContractNotificationImpl;
import fpml.confirmation.AbstractServicingNotification;
import fpml.confirmation.AbstractServicingNotification.AbstractServicingNotificationBuilder;
import fpml.confirmation.AbstractServicingNotification.AbstractServicingNotificationBuilderImpl;
import fpml.confirmation.AbstractServicingNotification.AbstractServicingNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AbstractContractNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An extension of the AbstractServicingNotification which includes a reference to the facility and the loan contract to which embedded loan events apply. This abtract type should be used to &#39;wrap&#39; contract-level business events.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractContractNotification", builder=AbstractContractNotification.AbstractContractNotificationBuilderImpl.class, version="${project.version}")
public interface AbstractContractNotification extends AbstractServicingNotification {

	AbstractContractNotificationMeta metaData = new AbstractContractNotificationMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends FacilityOutstandingsPosition> getFacilityOutstandingsPosition();

	/*********************** Build Methods  ***********************/
	AbstractContractNotification build();
	
	AbstractContractNotification.AbstractContractNotificationBuilder toBuilder();
	
	static AbstractContractNotification.AbstractContractNotificationBuilder builder() {
		return new AbstractContractNotification.AbstractContractNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractContractNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractContractNotification> getType() {
		return AbstractContractNotification.class;
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
		processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.class, getFacilityOutstandingsPosition());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractContractNotificationBuilder extends AbstractContractNotification, AbstractServicingNotification.AbstractServicingNotificationBuilder {
		FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getOrCreateFacilityOutstandingsPosition(int _index);
		List<? extends FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder> getFacilityOutstandingsPosition();
		AbstractContractNotification.AbstractContractNotificationBuilder setExpectedBuild(Integer expectedBuild);
		AbstractContractNotification.AbstractContractNotificationBuilder setActualBuild(Integer actualBuild);
		AbstractContractNotification.AbstractContractNotificationBuilder setHeader(RequestMessageHeader header);
		AbstractContractNotification.AbstractContractNotificationBuilder setValidationModel(ValidationModel validationModel);
		AbstractContractNotification.AbstractContractNotificationBuilder setIsCorrection(Boolean isCorrection);
		AbstractContractNotification.AbstractContractNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		AbstractContractNotification.AbstractContractNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AbstractContractNotification.AbstractContractNotificationBuilder setNoticeDate(Date noticeDate);
		AbstractContractNotification.AbstractContractNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(EventPayment eventPayment0);
		AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(EventPayment eventPayment1, int _idx);
		AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment2);
		AbstractContractNotification.AbstractContractNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment3);
		AbstractContractNotification.AbstractContractNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition0);
		AbstractContractNotification.AbstractContractNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition1, int _idx);
		AbstractContractNotification.AbstractContractNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition2);
		AbstractContractNotification.AbstractContractNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition3);

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
			processRosetta(path.newSubPath("facilityOutstandingsPosition"), processor, FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder.class, getFacilityOutstandingsPosition());
		}
		

		AbstractContractNotification.AbstractContractNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractContractNotification  ***********************/
	class AbstractContractNotificationImpl extends AbstractServicingNotification.AbstractServicingNotificationImpl implements AbstractContractNotification {
		private final List<? extends FacilityOutstandingsPosition> facilityOutstandingsPosition;
		
		protected AbstractContractNotificationImpl(AbstractContractNotification.AbstractContractNotificationBuilder builder) {
			super(builder);
			this.facilityOutstandingsPosition = ofNullable(builder.getFacilityOutstandingsPosition()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityOutstandingsPosition")
		public List<? extends FacilityOutstandingsPosition> getFacilityOutstandingsPosition() {
			return facilityOutstandingsPosition;
		}
		
		@Override
		public AbstractContractNotification build() {
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder toBuilder() {
			AbstractContractNotification.AbstractContractNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractContractNotification.AbstractContractNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityOutstandingsPosition()).ifPresent(builder::setFacilityOutstandingsPosition);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractContractNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(facilityOutstandingsPosition, _that.getFacilityOutstandingsPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityOutstandingsPosition != null ? facilityOutstandingsPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractContractNotification {" +
				"facilityOutstandingsPosition=" + this.facilityOutstandingsPosition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractContractNotification  ***********************/
	class AbstractContractNotificationBuilderImpl extends AbstractServicingNotification.AbstractServicingNotificationBuilderImpl  implements AbstractContractNotification.AbstractContractNotificationBuilder {
	
		protected List<FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder> facilityOutstandingsPosition = new ArrayList<>();
	
		public AbstractContractNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityOutstandingsPosition")
		public List<? extends FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder> getFacilityOutstandingsPosition() {
			return facilityOutstandingsPosition;
		}
		
		public FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder getOrCreateFacilityOutstandingsPosition(int _index) {
		
			if (facilityOutstandingsPosition==null) {
				this.facilityOutstandingsPosition = new ArrayList<>();
			}
			FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder result;
			return getIndex(facilityOutstandingsPosition, _index, () -> {
						FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder newFacilityOutstandingsPosition = FacilityOutstandingsPosition.builder();
						return newFacilityOutstandingsPosition;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public AbstractContractNotification.AbstractContractNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AbstractContractNotification.AbstractContractNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AbstractContractNotification.AbstractContractNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AbstractContractNotification.AbstractContractNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public AbstractContractNotification.AbstractContractNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public AbstractContractNotification.AbstractContractNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AbstractContractNotification.AbstractContractNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noticeDate")
		public AbstractContractNotification.AbstractContractNotificationBuilder setNoticeDate(Date noticeDate) {
			this.noticeDate = noticeDate==null?null:noticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("isGlobalOnly")
		public AbstractContractNotification.AbstractContractNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly) {
			this.isGlobalOnly = isGlobalOnly==null?null:isGlobalOnly;
			return this;
		}
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(EventPayment eventPayment) {
			if (eventPayment!=null) this.eventPayment.add(eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(EventPayment eventPayment, int _idx) {
			getIndex(this.eventPayment, _idx, () -> eventPayment.toBuilder());
			return this;
		}
		@Override 
		public AbstractContractNotification.AbstractContractNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventPayment")
		public AbstractContractNotification.AbstractContractNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		public AbstractContractNotification.AbstractContractNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition) {
			if (facilityOutstandingsPosition!=null) this.facilityOutstandingsPosition.add(facilityOutstandingsPosition.toBuilder());
			return this;
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder addFacilityOutstandingsPosition(FacilityOutstandingsPosition facilityOutstandingsPosition, int _idx) {
			getIndex(this.facilityOutstandingsPosition, _idx, () -> facilityOutstandingsPosition.toBuilder());
			return this;
		}
		@Override 
		public AbstractContractNotification.AbstractContractNotificationBuilder addFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
			if (facilityOutstandingsPositions != null) {
				for (FacilityOutstandingsPosition toAdd : facilityOutstandingsPositions) {
					this.facilityOutstandingsPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("facilityOutstandingsPosition")
		public AbstractContractNotification.AbstractContractNotificationBuilder setFacilityOutstandingsPosition(List<? extends FacilityOutstandingsPosition> facilityOutstandingsPositions) {
			if (facilityOutstandingsPositions == null)  {
				this.facilityOutstandingsPosition = new ArrayList<>();
			}
			else {
				this.facilityOutstandingsPosition = facilityOutstandingsPositions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AbstractContractNotification build() {
			return new AbstractContractNotification.AbstractContractNotificationImpl(this);
		}
		
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder prune() {
			super.prune();
			facilityOutstandingsPosition = facilityOutstandingsPosition.stream().filter(b->b!=null).<FacilityOutstandingsPosition.FacilityOutstandingsPositionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityOutstandingsPosition()!=null && getFacilityOutstandingsPosition().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractContractNotification.AbstractContractNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractContractNotification.AbstractContractNotificationBuilder o = (AbstractContractNotification.AbstractContractNotificationBuilder) other;
			
			merger.mergeRosetta(getFacilityOutstandingsPosition(), o.getFacilityOutstandingsPosition(), this::getOrCreateFacilityOutstandingsPosition);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractContractNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(facilityOutstandingsPosition, _that.getFacilityOutstandingsPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityOutstandingsPosition != null ? facilityOutstandingsPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractContractNotificationBuilder {" +
				"facilityOutstandingsPosition=" + this.facilityOutstandingsPosition +
			'}' + " " + super.toString();
		}
	}
}
