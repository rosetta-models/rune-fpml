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
import fpml.confirmation.FxDisruptionEvents;
import fpml.confirmation.FxDisruptionFallbacks;
import fpml.confirmation.FxDisruptionProvisions;
import fpml.confirmation.FxDisruptionProvisions.FxDisruptionProvisionsBuilder;
import fpml.confirmation.FxDisruptionProvisions.FxDisruptionProvisionsBuilderImpl;
import fpml.confirmation.FxDisruptionProvisions.FxDisruptionProvisionsImpl;
import fpml.confirmation.FxTemplateTerms;
import fpml.confirmation.meta.FxDisruptionProvisionsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes a set of disruption events and the fallbacks they will invoke
 * @version ${project.version}
 */
@RosettaDataType(value="FxDisruptionProvisions", builder=FxDisruptionProvisions.FxDisruptionProvisionsBuilderImpl.class, version="${project.version}")
public interface FxDisruptionProvisions extends RosettaModelObject {

	FxDisruptionProvisionsMeta metaData = new FxDisruptionProvisionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If any of the events listed in this section occurs then the associated fallbacks willl be applied.
	 */
	FxDisruptionEvents getEvents();
	/**
	 * Describes the fallback processing or termination procedures that can be applied if an event occurs,
	 */
	FxDisruptionFallbacks getFallbacks();
	/**
	 * Indicates the template terms that describe the events and fallbacks.
	 */
	FxTemplateTerms getApplicableTerms();

	/*********************** Build Methods  ***********************/
	FxDisruptionProvisions build();
	
	FxDisruptionProvisions.FxDisruptionProvisionsBuilder toBuilder();
	
	static FxDisruptionProvisions.FxDisruptionProvisionsBuilder builder() {
		return new FxDisruptionProvisions.FxDisruptionProvisionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDisruptionProvisions> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxDisruptionProvisions> getType() {
		return FxDisruptionProvisions.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("events"), processor, FxDisruptionEvents.class, getEvents());
		processRosetta(path.newSubPath("fallbacks"), processor, FxDisruptionFallbacks.class, getFallbacks());
		processRosetta(path.newSubPath("applicableTerms"), processor, FxTemplateTerms.class, getApplicableTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDisruptionProvisionsBuilder extends FxDisruptionProvisions, RosettaModelObjectBuilder {
		FxDisruptionEvents.FxDisruptionEventsBuilder getOrCreateEvents();
		FxDisruptionEvents.FxDisruptionEventsBuilder getEvents();
		FxDisruptionFallbacks.FxDisruptionFallbacksBuilder getOrCreateFallbacks();
		FxDisruptionFallbacks.FxDisruptionFallbacksBuilder getFallbacks();
		FxTemplateTerms.FxTemplateTermsBuilder getOrCreateApplicableTerms();
		FxTemplateTerms.FxTemplateTermsBuilder getApplicableTerms();
		FxDisruptionProvisions.FxDisruptionProvisionsBuilder setEvents(FxDisruptionEvents events);
		FxDisruptionProvisions.FxDisruptionProvisionsBuilder setFallbacks(FxDisruptionFallbacks fallbacks);
		FxDisruptionProvisions.FxDisruptionProvisionsBuilder setApplicableTerms(FxTemplateTerms applicableTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("events"), processor, FxDisruptionEvents.FxDisruptionEventsBuilder.class, getEvents());
			processRosetta(path.newSubPath("fallbacks"), processor, FxDisruptionFallbacks.FxDisruptionFallbacksBuilder.class, getFallbacks());
			processRosetta(path.newSubPath("applicableTerms"), processor, FxTemplateTerms.FxTemplateTermsBuilder.class, getApplicableTerms());
		}
		

		FxDisruptionProvisions.FxDisruptionProvisionsBuilder prune();
	}

	/*********************** Immutable Implementation of FxDisruptionProvisions  ***********************/
	class FxDisruptionProvisionsImpl implements FxDisruptionProvisions {
		private final FxDisruptionEvents events;
		private final FxDisruptionFallbacks fallbacks;
		private final FxTemplateTerms applicableTerms;
		
		protected FxDisruptionProvisionsImpl(FxDisruptionProvisions.FxDisruptionProvisionsBuilder builder) {
			this.events = ofNullable(builder.getEvents()).map(f->f.build()).orElse(null);
			this.fallbacks = ofNullable(builder.getFallbacks()).map(f->f.build()).orElse(null);
			this.applicableTerms = ofNullable(builder.getApplicableTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("events")
		public FxDisruptionEvents getEvents() {
			return events;
		}
		
		@Override
		@RosettaAttribute("fallbacks")
		public FxDisruptionFallbacks getFallbacks() {
			return fallbacks;
		}
		
		@Override
		@RosettaAttribute("applicableTerms")
		public FxTemplateTerms getApplicableTerms() {
			return applicableTerms;
		}
		
		@Override
		public FxDisruptionProvisions build() {
			return this;
		}
		
		@Override
		public FxDisruptionProvisions.FxDisruptionProvisionsBuilder toBuilder() {
			FxDisruptionProvisions.FxDisruptionProvisionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDisruptionProvisions.FxDisruptionProvisionsBuilder builder) {
			ofNullable(getEvents()).ifPresent(builder::setEvents);
			ofNullable(getFallbacks()).ifPresent(builder::setFallbacks);
			ofNullable(getApplicableTerms()).ifPresent(builder::setApplicableTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruptionProvisions _that = getType().cast(o);
		
			if (!Objects.equals(events, _that.getEvents())) return false;
			if (!Objects.equals(fallbacks, _that.getFallbacks())) return false;
			if (!Objects.equals(applicableTerms, _that.getApplicableTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (events != null ? events.hashCode() : 0);
			_result = 31 * _result + (fallbacks != null ? fallbacks.hashCode() : 0);
			_result = 31 * _result + (applicableTerms != null ? applicableTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionProvisions {" +
				"events=" + this.events + ", " +
				"fallbacks=" + this.fallbacks + ", " +
				"applicableTerms=" + this.applicableTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDisruptionProvisions  ***********************/
	class FxDisruptionProvisionsBuilderImpl implements FxDisruptionProvisions.FxDisruptionProvisionsBuilder {
	
		protected FxDisruptionEvents.FxDisruptionEventsBuilder events;
		protected FxDisruptionFallbacks.FxDisruptionFallbacksBuilder fallbacks;
		protected FxTemplateTerms.FxTemplateTermsBuilder applicableTerms;
	
		public FxDisruptionProvisionsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("events")
		public FxDisruptionEvents.FxDisruptionEventsBuilder getEvents() {
			return events;
		}
		
		@Override
		public FxDisruptionEvents.FxDisruptionEventsBuilder getOrCreateEvents() {
			FxDisruptionEvents.FxDisruptionEventsBuilder result;
			if (events!=null) {
				result = events;
			}
			else {
				result = events = FxDisruptionEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fallbacks")
		public FxDisruptionFallbacks.FxDisruptionFallbacksBuilder getFallbacks() {
			return fallbacks;
		}
		
		@Override
		public FxDisruptionFallbacks.FxDisruptionFallbacksBuilder getOrCreateFallbacks() {
			FxDisruptionFallbacks.FxDisruptionFallbacksBuilder result;
			if (fallbacks!=null) {
				result = fallbacks;
			}
			else {
				result = fallbacks = FxDisruptionFallbacks.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("applicableTerms")
		public FxTemplateTerms.FxTemplateTermsBuilder getApplicableTerms() {
			return applicableTerms;
		}
		
		@Override
		public FxTemplateTerms.FxTemplateTermsBuilder getOrCreateApplicableTerms() {
			FxTemplateTerms.FxTemplateTermsBuilder result;
			if (applicableTerms!=null) {
				result = applicableTerms;
			}
			else {
				result = applicableTerms = FxTemplateTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("events")
		public FxDisruptionProvisions.FxDisruptionProvisionsBuilder setEvents(FxDisruptionEvents events) {
			this.events = events==null?null:events.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fallbacks")
		public FxDisruptionProvisions.FxDisruptionProvisionsBuilder setFallbacks(FxDisruptionFallbacks fallbacks) {
			this.fallbacks = fallbacks==null?null:fallbacks.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("applicableTerms")
		public FxDisruptionProvisions.FxDisruptionProvisionsBuilder setApplicableTerms(FxTemplateTerms applicableTerms) {
			this.applicableTerms = applicableTerms==null?null:applicableTerms.toBuilder();
			return this;
		}
		
		@Override
		public FxDisruptionProvisions build() {
			return new FxDisruptionProvisions.FxDisruptionProvisionsImpl(this);
		}
		
		@Override
		public FxDisruptionProvisions.FxDisruptionProvisionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionProvisions.FxDisruptionProvisionsBuilder prune() {
			if (events!=null && !events.prune().hasData()) events = null;
			if (fallbacks!=null && !fallbacks.prune().hasData()) fallbacks = null;
			if (applicableTerms!=null && !applicableTerms.prune().hasData()) applicableTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEvents()!=null && getEvents().hasData()) return true;
			if (getFallbacks()!=null && getFallbacks().hasData()) return true;
			if (getApplicableTerms()!=null && getApplicableTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionProvisions.FxDisruptionProvisionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDisruptionProvisions.FxDisruptionProvisionsBuilder o = (FxDisruptionProvisions.FxDisruptionProvisionsBuilder) other;
			
			merger.mergeRosetta(getEvents(), o.getEvents(), this::setEvents);
			merger.mergeRosetta(getFallbacks(), o.getFallbacks(), this::setFallbacks);
			merger.mergeRosetta(getApplicableTerms(), o.getApplicableTerms(), this::setApplicableTerms);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruptionProvisions _that = getType().cast(o);
		
			if (!Objects.equals(events, _that.getEvents())) return false;
			if (!Objects.equals(fallbacks, _that.getFallbacks())) return false;
			if (!Objects.equals(applicableTerms, _that.getApplicableTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (events != null ? events.hashCode() : 0);
			_result = 31 * _result + (fallbacks != null ? fallbacks.hashCode() : 0);
			_result = 31 * _result + (applicableTerms != null ? applicableTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionProvisionsBuilder {" +
				"events=" + this.events + ", " +
				"fallbacks=" + this.fallbacks + ", " +
				"applicableTerms=" + this.applicableTerms +
			'}';
		}
	}
}
