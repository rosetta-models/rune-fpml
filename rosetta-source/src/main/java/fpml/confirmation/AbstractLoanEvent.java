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
import fpml.confirmation.AbstractEventRequireId;
import fpml.confirmation.AbstractEventRequireId.AbstractEventRequireIdBuilder;
import fpml.confirmation.AbstractEventRequireId.AbstractEventRequireIdBuilderImpl;
import fpml.confirmation.AbstractEventRequireId.AbstractEventRequireIdImpl;
import fpml.confirmation.AbstractLoanEvent;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventBuilder;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventBuilderImpl;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.AbstractLoanEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type defining common features of a syndicated loan business event.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLoanEvent", builder=AbstractLoanEvent.AbstractLoanEventBuilderImpl.class, version="${project.version}")
public interface AbstractLoanEvent extends AbstractEventRequireId {

	AbstractLoanEventMeta metaData = new AbstractLoanEventMeta();

	/*********************** Getter Methods  ***********************/
	BusinessEventIdentifier getParentEventIdentifier();
	/**
	 * A unique id associated with a previous inaccurate event. Population of this identifier reflects the fact that this new event is being used to apply a &#39;corrective measure&#39; to the referenced event (rather than this being an actual real-life event). The net result (across both events) ensures accurate accounting.
	 */
	BusinessEventIdentifier getCorrectedEventIdentifier();
	LenderAndCashDetailsModel getLenderAndCashDetailsModel();
	/**
	 * A freetext field which allows the sender to add further details around the business event.
	 */
	String getComment();

	/*********************** Build Methods  ***********************/
	AbstractLoanEvent build();
	
	AbstractLoanEvent.AbstractLoanEventBuilder toBuilder();
	
	static AbstractLoanEvent.AbstractLoanEventBuilder builder() {
		return new AbstractLoanEvent.AbstractLoanEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanEvent> getType() {
		return AbstractLoanEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanEventBuilder extends AbstractLoanEvent, AbstractEventRequireId.AbstractEventRequireIdBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateParentEventIdentifier();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getParentEventIdentifier();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateCorrectedEventIdentifier();
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getCorrectedEventIdentifier();
		LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder getOrCreateLenderAndCashDetailsModel();
		LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder getLenderAndCashDetailsModel();
		AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AbstractLoanEvent.AbstractLoanEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AbstractLoanEvent.AbstractLoanEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AbstractLoanEvent.AbstractLoanEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AbstractLoanEvent.AbstractLoanEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AbstractLoanEvent.AbstractLoanEventBuilder setComment(String comment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		}
		

		AbstractLoanEvent.AbstractLoanEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanEvent  ***********************/
	class AbstractLoanEventImpl extends AbstractEventRequireId.AbstractEventRequireIdImpl implements AbstractLoanEvent {
		private final BusinessEventIdentifier parentEventIdentifier;
		private final BusinessEventIdentifier correctedEventIdentifier;
		private final LenderAndCashDetailsModel lenderAndCashDetailsModel;
		private final String comment;
		
		protected AbstractLoanEventImpl(AbstractLoanEvent.AbstractLoanEventBuilder builder) {
			super(builder);
			this.parentEventIdentifier = ofNullable(builder.getParentEventIdentifier()).map(f->f.build()).orElse(null);
			this.correctedEventIdentifier = ofNullable(builder.getCorrectedEventIdentifier()).map(f->f.build()).orElse(null);
			this.lenderAndCashDetailsModel = ofNullable(builder.getLenderAndCashDetailsModel()).map(f->f.build()).orElse(null);
			this.comment = builder.getComment();
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		public BusinessEventIdentifier getParentEventIdentifier() {
			return parentEventIdentifier;
		}
		
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public BusinessEventIdentifier getCorrectedEventIdentifier() {
			return correctedEventIdentifier;
		}
		
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LenderAndCashDetailsModel getLenderAndCashDetailsModel() {
			return lenderAndCashDetailsModel;
		}
		
		@Override
		@RosettaAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@Override
		public AbstractLoanEvent build() {
			return this;
		}
		
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder toBuilder() {
			AbstractLoanEvent.AbstractLoanEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanEvent.AbstractLoanEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getParentEventIdentifier()).ifPresent(builder::setParentEventIdentifier);
			ofNullable(getCorrectedEventIdentifier()).ifPresent(builder::setCorrectedEventIdentifier);
			ofNullable(getLenderAndCashDetailsModel()).ifPresent(builder::setLenderAndCashDetailsModel);
			ofNullable(getComment()).ifPresent(builder::setComment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanEvent _that = getType().cast(o);
		
			if (!Objects.equals(parentEventIdentifier, _that.getParentEventIdentifier())) return false;
			if (!Objects.equals(correctedEventIdentifier, _that.getCorrectedEventIdentifier())) return false;
			if (!Objects.equals(lenderAndCashDetailsModel, _that.getLenderAndCashDetailsModel())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (parentEventIdentifier != null ? parentEventIdentifier.hashCode() : 0);
			_result = 31 * _result + (correctedEventIdentifier != null ? correctedEventIdentifier.hashCode() : 0);
			_result = 31 * _result + (lenderAndCashDetailsModel != null ? lenderAndCashDetailsModel.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanEvent {" +
				"parentEventIdentifier=" + this.parentEventIdentifier + ", " +
				"correctedEventIdentifier=" + this.correctedEventIdentifier + ", " +
				"lenderAndCashDetailsModel=" + this.lenderAndCashDetailsModel + ", " +
				"comment=" + this.comment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanEvent  ***********************/
	class AbstractLoanEventBuilderImpl extends AbstractEventRequireId.AbstractEventRequireIdBuilderImpl  implements AbstractLoanEvent.AbstractLoanEventBuilder {
	
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder parentEventIdentifier;
		protected BusinessEventIdentifier.BusinessEventIdentifierBuilder correctedEventIdentifier;
		protected LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder lenderAndCashDetailsModel;
		protected String comment;
	
		public AbstractLoanEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("parentEventIdentifier")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getParentEventIdentifier() {
			return parentEventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateParentEventIdentifier() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder result;
			if (parentEventIdentifier!=null) {
				result = parentEventIdentifier;
			}
			else {
				result = parentEventIdentifier = BusinessEventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getCorrectedEventIdentifier() {
			return correctedEventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateCorrectedEventIdentifier() {
			BusinessEventIdentifier.BusinessEventIdentifierBuilder result;
			if (correctedEventIdentifier!=null) {
				result = correctedEventIdentifier;
			}
			else {
				result = correctedEventIdentifier = BusinessEventIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder getLenderAndCashDetailsModel() {
			return lenderAndCashDetailsModel;
		}
		
		@Override
		public LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder getOrCreateLenderAndCashDetailsModel() {
			LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder result;
			if (lenderAndCashDetailsModel!=null) {
				result = lenderAndCashDetailsModel;
			}
			else {
				result = lenderAndCashDetailsModel = LenderAndCashDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractLoanEvent.AbstractLoanEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public AbstractLoanEvent.AbstractLoanEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanEvent.AbstractLoanEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AbstractLoanEvent.AbstractLoanEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AbstractLoanEvent.AbstractLoanEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractLoanEvent.AbstractLoanEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		
		@Override
		public AbstractLoanEvent build() {
			return new AbstractLoanEvent.AbstractLoanEventImpl(this);
		}
		
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder prune() {
			super.prune();
			if (parentEventIdentifier!=null && !parentEventIdentifier.prune().hasData()) parentEventIdentifier = null;
			if (correctedEventIdentifier!=null && !correctedEventIdentifier.prune().hasData()) correctedEventIdentifier = null;
			if (lenderAndCashDetailsModel!=null && !lenderAndCashDetailsModel.prune().hasData()) lenderAndCashDetailsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getParentEventIdentifier()!=null && getParentEventIdentifier().hasData()) return true;
			if (getCorrectedEventIdentifier()!=null && getCorrectedEventIdentifier().hasData()) return true;
			if (getLenderAndCashDetailsModel()!=null && getLenderAndCashDetailsModel().hasData()) return true;
			if (getComment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanEvent.AbstractLoanEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanEvent.AbstractLoanEventBuilder o = (AbstractLoanEvent.AbstractLoanEventBuilder) other;
			
			merger.mergeRosetta(getParentEventIdentifier(), o.getParentEventIdentifier(), this::setParentEventIdentifier);
			merger.mergeRosetta(getCorrectedEventIdentifier(), o.getCorrectedEventIdentifier(), this::setCorrectedEventIdentifier);
			merger.mergeRosetta(getLenderAndCashDetailsModel(), o.getLenderAndCashDetailsModel(), this::setLenderAndCashDetailsModel);
			
			merger.mergeBasic(getComment(), o.getComment(), this::setComment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanEvent _that = getType().cast(o);
		
			if (!Objects.equals(parentEventIdentifier, _that.getParentEventIdentifier())) return false;
			if (!Objects.equals(correctedEventIdentifier, _that.getCorrectedEventIdentifier())) return false;
			if (!Objects.equals(lenderAndCashDetailsModel, _that.getLenderAndCashDetailsModel())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (parentEventIdentifier != null ? parentEventIdentifier.hashCode() : 0);
			_result = 31 * _result + (correctedEventIdentifier != null ? correctedEventIdentifier.hashCode() : 0);
			_result = 31 * _result + (lenderAndCashDetailsModel != null ? lenderAndCashDetailsModel.hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanEventBuilder {" +
				"parentEventIdentifier=" + this.parentEventIdentifier + ", " +
				"correctedEventIdentifier=" + this.correctedEventIdentifier + ", " +
				"lenderAndCashDetailsModel=" + this.lenderAndCashDetailsModel + ", " +
				"comment=" + this.comment +
			'}' + " " + super.toString();
		}
	}
}
