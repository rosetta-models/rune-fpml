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
import fpml.confirmation.AbstractLoanEvent;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventBuilder;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventBuilderImpl;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventImpl;
import fpml.confirmation.AbstractLoanServicingEvent;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.AbstractLoanServicingEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type defining common features of a syndicated loan servicing business event. Such events are originated by the borrower and are required to be communicated to the lender syndicate by agents.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLoanServicingEvent", builder=AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl.class, version="${project.version}")
public interface AbstractLoanServicingEvent extends AbstractLoanEvent {

	AbstractLoanServicingEventMeta metaData = new AbstractLoanServicingEventMeta();

	/*********************** Getter Methods  ***********************/
	BusinessEventPartiesModel getBusinessEventPartiesModel();
	/**
	 * The date on which the associated business event is effective.
	 */
	Date getEffectiveDate();

	/*********************** Build Methods  ***********************/
	AbstractLoanServicingEvent build();
	
	AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder toBuilder();
	
	static AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder builder() {
		return new AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanServicingEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanServicingEvent> getType() {
		return AbstractLoanServicingEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.class, getBusinessEventPartiesModel());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanServicingEventBuilder extends AbstractLoanServicingEvent, AbstractLoanEvent.AbstractLoanEventBuilder {
		BusinessEventPartiesModel.BusinessEventPartiesModelBuilder getOrCreateBusinessEventPartiesModel();
		BusinessEventPartiesModel.BusinessEventPartiesModelBuilder getBusinessEventPartiesModel();
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setComment(String comment);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setEffectiveDate(Date effectiveDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		}
		

		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanServicingEvent  ***********************/
	class AbstractLoanServicingEventImpl extends AbstractLoanEvent.AbstractLoanEventImpl implements AbstractLoanServicingEvent {
		private final BusinessEventPartiesModel businessEventPartiesModel;
		private final Date effectiveDate;
		
		protected AbstractLoanServicingEventImpl(AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder builder) {
			super(builder);
			this.businessEventPartiesModel = ofNullable(builder.getBusinessEventPartiesModel()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
		}
		
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public BusinessEventPartiesModel getBusinessEventPartiesModel() {
			return businessEventPartiesModel;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AbstractLoanServicingEvent build() {
			return this;
		}
		
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder toBuilder() {
			AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessEventPartiesModel()).ifPresent(builder::setBusinessEventPartiesModel);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanServicingEvent _that = getType().cast(o);
		
			if (!Objects.equals(businessEventPartiesModel, _that.getBusinessEventPartiesModel())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessEventPartiesModel != null ? businessEventPartiesModel.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanServicingEvent {" +
				"businessEventPartiesModel=" + this.businessEventPartiesModel + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanServicingEvent  ***********************/
	class AbstractLoanServicingEventBuilderImpl extends AbstractLoanEvent.AbstractLoanEventBuilderImpl  implements AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder {
	
		protected BusinessEventPartiesModel.BusinessEventPartiesModelBuilder businessEventPartiesModel;
		protected Date effectiveDate;
	
		public AbstractLoanServicingEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public BusinessEventPartiesModel.BusinessEventPartiesModelBuilder getBusinessEventPartiesModel() {
			return businessEventPartiesModel;
		}
		
		@Override
		public BusinessEventPartiesModel.BusinessEventPartiesModelBuilder getOrCreateBusinessEventPartiesModel() {
			BusinessEventPartiesModel.BusinessEventPartiesModelBuilder result;
			if (businessEventPartiesModel!=null) {
				result = businessEventPartiesModel;
			}
			else {
				result = businessEventPartiesModel = BusinessEventPartiesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		
		@Override
		public AbstractLoanServicingEvent build() {
			return new AbstractLoanServicingEvent.AbstractLoanServicingEventImpl(this);
		}
		
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder prune() {
			super.prune();
			if (businessEventPartiesModel!=null && !businessEventPartiesModel.prune().hasData()) businessEventPartiesModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessEventPartiesModel()!=null && getBusinessEventPartiesModel().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder o = (AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder) other;
			
			merger.mergeRosetta(getBusinessEventPartiesModel(), o.getBusinessEventPartiesModel(), this::setBusinessEventPartiesModel);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanServicingEvent _that = getType().cast(o);
		
			if (!Objects.equals(businessEventPartiesModel, _that.getBusinessEventPartiesModel())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessEventPartiesModel != null ? businessEventPartiesModel.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanServicingEventBuilder {" +
				"businessEventPartiesModel=" + this.businessEventPartiesModel + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}' + " " + super.toString();
		}
	}
}
