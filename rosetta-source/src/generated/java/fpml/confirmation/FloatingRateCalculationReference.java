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
import fpml.confirmation.FloatingRateCalculationReference;
import fpml.confirmation.FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder;
import fpml.confirmation.FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilderImpl;
import fpml.confirmation.FloatingRateCalculationReference.FloatingRateCalculationReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FloatingRateCalculationReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a floating rate calculation of interest calculation component.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRateCalculationReference", builder=FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilderImpl.class, version="${project.version}")
public interface FloatingRateCalculationReference extends Reference {

	FloatingRateCalculationReferenceMeta metaData = new FloatingRateCalculationReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FloatingRateCalculationReference build();
	
	FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder toBuilder();
	
	static FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder builder() {
		return new FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateCalculationReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateCalculationReference> getType() {
		return FloatingRateCalculationReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateCalculationReferenceBuilder extends FloatingRateCalculationReference, Reference.ReferenceBuilder {
		FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateCalculationReference  ***********************/
	class FloatingRateCalculationReferenceImpl extends Reference.ReferenceImpl implements FloatingRateCalculationReference {
		private final String href;
		
		protected FloatingRateCalculationReferenceImpl(FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FloatingRateCalculationReference build() {
			return this;
		}
		
		@Override
		public FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder toBuilder() {
			FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateCalculationReference _that = getType().cast(o);
		
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
			return "FloatingRateCalculationReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRateCalculationReference  ***********************/
	class FloatingRateCalculationReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder {
	
		protected String href;
	
		public FloatingRateCalculationReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FloatingRateCalculationReference build() {
			return new FloatingRateCalculationReference.FloatingRateCalculationReferenceImpl(this);
		}
		
		@Override
		public FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder prune() {
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
		public FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder o = (FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateCalculationReference _that = getType().cast(o);
		
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
			return "FloatingRateCalculationReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
