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
import fpml.confirmation.AbstractLoanAllocationEvent;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl;
import fpml.confirmation.AbstractLoanEvent;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventBuilder;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventBuilderImpl;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.meta.AbstractLoanAllocationEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract structure defining fundamental allocation event information.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AbstractLoanAllocationEvent", builder=AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AbstractLoanAllocationEvent extends AbstractLoanEvent {

	AbstractLoanAllocationEventMeta metaData = new AbstractLoanAllocationEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to an allocation.
	 */
	List<? extends LoanAllocationReference> getAllocationReference();

	/*********************** Build Methods  ***********************/
	AbstractLoanAllocationEvent build();
	
	AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder toBuilder();
	
	static AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder builder() {
		return new AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanAllocationEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanAllocationEvent> getType() {
		return AbstractLoanAllocationEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanAllocationEventBuilder extends AbstractLoanAllocationEvent, AbstractLoanEvent.AbstractLoanEventBuilder {
		LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference(int _index);
		List<? extends LoanAllocationReference.LoanAllocationReferenceBuilder> getAllocationReference();
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setComment(String comment);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addAllocationReference(LoanAllocationReference allocationReference0);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addAllocationReference(LoanAllocationReference allocationReference1, int _idx);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReference2);
		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
		}
		

		AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanAllocationEvent  ***********************/
	class AbstractLoanAllocationEventImpl extends AbstractLoanEvent.AbstractLoanEventImpl implements AbstractLoanAllocationEvent {
		private final List<? extends LoanAllocationReference> allocationReference;
		
		protected AbstractLoanAllocationEventImpl(AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder builder) {
			super(builder);
			this.allocationReference = ofNullable(builder.getAllocationReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationReference")
		public List<? extends LoanAllocationReference> getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		public AbstractLoanAllocationEvent build() {
			return this;
		}
		
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder toBuilder() {
			AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAllocationReference()).ifPresent(builder::setAllocationReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationReference, _that.getAllocationReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationEvent {" +
				"allocationReference=" + this.allocationReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanAllocationEvent  ***********************/
	class AbstractLoanAllocationEventBuilderImpl extends AbstractLoanEvent.AbstractLoanEventBuilderImpl  implements AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
	
		protected List<LoanAllocationReference.LoanAllocationReferenceBuilder> allocationReference = new ArrayList<>();
	
		public AbstractLoanAllocationEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("allocationReference")
		public List<? extends LoanAllocationReference.LoanAllocationReferenceBuilder> getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		public LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference(int _index) {
		
			if (allocationReference==null) {
				this.allocationReference = new ArrayList<>();
			}
			LoanAllocationReference.LoanAllocationReferenceBuilder result;
			return getIndex(allocationReference, _index, () -> {
						LoanAllocationReference.LoanAllocationReferenceBuilder newAllocationReference = LoanAllocationReference.builder();
						return newAllocationReference;
					});
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("allocationReference")
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addAllocationReference(LoanAllocationReference allocationReference) {
			if (allocationReference!=null) this.allocationReference.add(allocationReference.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addAllocationReference(LoanAllocationReference allocationReference, int _idx) {
			getIndex(this.allocationReference, _idx, () -> allocationReference.toBuilder());
			return this;
		}
		@Override 
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences != null) {
				for (LoanAllocationReference toAdd : allocationReferences) {
					this.allocationReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences == null)  {
				this.allocationReference = new ArrayList<>();
			}
			else {
				this.allocationReference = allocationReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AbstractLoanAllocationEvent build() {
			return new AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl(this);
		}
		
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder prune() {
			super.prune();
			allocationReference = allocationReference.stream().filter(b->b!=null).<LoanAllocationReference.LoanAllocationReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAllocationReference()!=null && getAllocationReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder o = (AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder) other;
			
			merger.mergeRosetta(getAllocationReference(), o.getAllocationReference(), this::getOrCreateAllocationReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanAllocationEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationReference, _that.getAllocationReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanAllocationEventBuilder {" +
				"allocationReference=" + this.allocationReference +
			'}' + " " + super.toString();
		}
	}
}
