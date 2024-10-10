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
import fpml.confirmation.CreditEvents;
import fpml.confirmation.CreditEventsReference;
import fpml.confirmation.TriggerChoice;
import fpml.confirmation.TriggerChoice.TriggerChoiceBuilder;
import fpml.confirmation.TriggerChoice.TriggerChoiceBuilderImpl;
import fpml.confirmation.TriggerChoice.TriggerChoiceImpl;
import fpml.confirmation.meta.TriggerChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TriggerChoice", builder=TriggerChoice.TriggerChoiceBuilderImpl.class, version="${project.version}")
public interface TriggerChoice extends RosettaModelObject {

	TriggerChoiceMeta metaData = new TriggerChoiceMeta();

	/*********************** Getter Methods  ***********************/
	CreditEvents getCreditEvents();
	CreditEventsReference getCreditEventsReference();

	/*********************** Build Methods  ***********************/
	TriggerChoice build();
	
	TriggerChoice.TriggerChoiceBuilder toBuilder();
	
	static TriggerChoice.TriggerChoiceBuilder builder() {
		return new TriggerChoice.TriggerChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TriggerChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TriggerChoice> getType() {
		return TriggerChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.class, getCreditEvents());
		processRosetta(path.newSubPath("creditEventsReference"), processor, CreditEventsReference.class, getCreditEventsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TriggerChoiceBuilder extends TriggerChoice, RosettaModelObjectBuilder {
		CreditEvents.CreditEventsBuilder getOrCreateCreditEvents();
		CreditEvents.CreditEventsBuilder getCreditEvents();
		CreditEventsReference.CreditEventsReferenceBuilder getOrCreateCreditEventsReference();
		CreditEventsReference.CreditEventsReferenceBuilder getCreditEventsReference();
		TriggerChoice.TriggerChoiceBuilder setCreditEvents(CreditEvents creditEvents);
		TriggerChoice.TriggerChoiceBuilder setCreditEventsReference(CreditEventsReference creditEventsReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.CreditEventsBuilder.class, getCreditEvents());
			processRosetta(path.newSubPath("creditEventsReference"), processor, CreditEventsReference.CreditEventsReferenceBuilder.class, getCreditEventsReference());
		}
		

		TriggerChoice.TriggerChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of TriggerChoice  ***********************/
	class TriggerChoiceImpl implements TriggerChoice {
		private final CreditEvents creditEvents;
		private final CreditEventsReference creditEventsReference;
		
		protected TriggerChoiceImpl(TriggerChoice.TriggerChoiceBuilder builder) {
			this.creditEvents = ofNullable(builder.getCreditEvents()).map(f->f.build()).orElse(null);
			this.creditEventsReference = ofNullable(builder.getCreditEventsReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditEvents")
		public CreditEvents getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		@RosettaAttribute("creditEventsReference")
		public CreditEventsReference getCreditEventsReference() {
			return creditEventsReference;
		}
		
		@Override
		public TriggerChoice build() {
			return this;
		}
		
		@Override
		public TriggerChoice.TriggerChoiceBuilder toBuilder() {
			TriggerChoice.TriggerChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TriggerChoice.TriggerChoiceBuilder builder) {
			ofNullable(getCreditEvents()).ifPresent(builder::setCreditEvents);
			ofNullable(getCreditEventsReference()).ifPresent(builder::setCreditEventsReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerChoice _that = getType().cast(o);
		
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(creditEventsReference, _that.getCreditEventsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (creditEventsReference != null ? creditEventsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerChoice {" +
				"creditEvents=" + this.creditEvents + ", " +
				"creditEventsReference=" + this.creditEventsReference +
			'}';
		}
	}

	/*********************** Builder Implementation of TriggerChoice  ***********************/
	class TriggerChoiceBuilderImpl implements TriggerChoice.TriggerChoiceBuilder {
	
		protected CreditEvents.CreditEventsBuilder creditEvents;
		protected CreditEventsReference.CreditEventsReferenceBuilder creditEventsReference;
	
		public TriggerChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("creditEvents")
		public CreditEvents.CreditEventsBuilder getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder getOrCreateCreditEvents() {
			CreditEvents.CreditEventsBuilder result;
			if (creditEvents!=null) {
				result = creditEvents;
			}
			else {
				result = creditEvents = CreditEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEventsReference")
		public CreditEventsReference.CreditEventsReferenceBuilder getCreditEventsReference() {
			return creditEventsReference;
		}
		
		@Override
		public CreditEventsReference.CreditEventsReferenceBuilder getOrCreateCreditEventsReference() {
			CreditEventsReference.CreditEventsReferenceBuilder result;
			if (creditEventsReference!=null) {
				result = creditEventsReference;
			}
			else {
				result = creditEventsReference = CreditEventsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEvents")
		public TriggerChoice.TriggerChoiceBuilder setCreditEvents(CreditEvents creditEvents) {
			this.creditEvents = creditEvents==null?null:creditEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEventsReference")
		public TriggerChoice.TriggerChoiceBuilder setCreditEventsReference(CreditEventsReference creditEventsReference) {
			this.creditEventsReference = creditEventsReference==null?null:creditEventsReference.toBuilder();
			return this;
		}
		
		@Override
		public TriggerChoice build() {
			return new TriggerChoice.TriggerChoiceImpl(this);
		}
		
		@Override
		public TriggerChoice.TriggerChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerChoice.TriggerChoiceBuilder prune() {
			if (creditEvents!=null && !creditEvents.prune().hasData()) creditEvents = null;
			if (creditEventsReference!=null && !creditEventsReference.prune().hasData()) creditEventsReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditEvents()!=null && getCreditEvents().hasData()) return true;
			if (getCreditEventsReference()!=null && getCreditEventsReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriggerChoice.TriggerChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TriggerChoice.TriggerChoiceBuilder o = (TriggerChoice.TriggerChoiceBuilder) other;
			
			merger.mergeRosetta(getCreditEvents(), o.getCreditEvents(), this::setCreditEvents);
			merger.mergeRosetta(getCreditEventsReference(), o.getCreditEventsReference(), this::setCreditEventsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriggerChoice _that = getType().cast(o);
		
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(creditEventsReference, _that.getCreditEventsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (creditEventsReference != null ? creditEventsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerChoiceBuilder {" +
				"creditEvents=" + this.creditEvents + ", " +
				"creditEventsReference=" + this.creditEventsReference +
			'}';
		}
	}
}
