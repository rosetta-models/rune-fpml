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
import fpml.confirmation.InterestLegCalculationPeriodDatesReference;
import fpml.confirmation.InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder;
import fpml.confirmation.InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilderImpl;
import fpml.confirmation.InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.InterestLegCalculationPeriodDatesReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to the calculation period dates of the interest leg.
 * @version ${project.version}
 */
@RosettaDataType(value="InterestLegCalculationPeriodDatesReference", builder=InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilderImpl.class, version="${project.version}")
public interface InterestLegCalculationPeriodDatesReference extends Reference {

	InterestLegCalculationPeriodDatesReferenceMeta metaData = new InterestLegCalculationPeriodDatesReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	InterestLegCalculationPeriodDatesReference build();
	
	InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder toBuilder();
	
	static InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder builder() {
		return new InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestLegCalculationPeriodDatesReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestLegCalculationPeriodDatesReference> getType() {
		return InterestLegCalculationPeriodDatesReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestLegCalculationPeriodDatesReferenceBuilder extends InterestLegCalculationPeriodDatesReference, Reference.ReferenceBuilder {
		InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of InterestLegCalculationPeriodDatesReference  ***********************/
	class InterestLegCalculationPeriodDatesReferenceImpl extends Reference.ReferenceImpl implements InterestLegCalculationPeriodDatesReference {
		private final String href;
		
		protected InterestLegCalculationPeriodDatesReferenceImpl(InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public InterestLegCalculationPeriodDatesReference build() {
			return this;
		}
		
		@Override
		public InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder toBuilder() {
			InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestLegCalculationPeriodDatesReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLegCalculationPeriodDatesReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestLegCalculationPeriodDatesReference  ***********************/
	class InterestLegCalculationPeriodDatesReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder {
	
		protected String href;
	
		public InterestLegCalculationPeriodDatesReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public InterestLegCalculationPeriodDatesReference build() {
			return new InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceImpl(this);
		}
		
		@Override
		public InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder o = (InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestLegCalculationPeriodDatesReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLegCalculationPeriodDatesReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
