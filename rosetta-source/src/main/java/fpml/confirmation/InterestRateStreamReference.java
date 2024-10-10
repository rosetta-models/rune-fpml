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
import fpml.confirmation.InterestRateStreamReference;
import fpml.confirmation.InterestRateStreamReference.InterestRateStreamReferenceBuilder;
import fpml.confirmation.InterestRateStreamReference.InterestRateStreamReferenceBuilderImpl;
import fpml.confirmation.InterestRateStreamReference.InterestRateStreamReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.InterestRateStreamReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to an InterestRateStream component.
 * @version ${project.version}
 */
@RosettaDataType(value="InterestRateStreamReference", builder=InterestRateStreamReference.InterestRateStreamReferenceBuilderImpl.class, version="${project.version}")
public interface InterestRateStreamReference extends Reference {

	InterestRateStreamReferenceMeta metaData = new InterestRateStreamReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	InterestRateStreamReference build();
	
	InterestRateStreamReference.InterestRateStreamReferenceBuilder toBuilder();
	
	static InterestRateStreamReference.InterestRateStreamReferenceBuilder builder() {
		return new InterestRateStreamReference.InterestRateStreamReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRateStreamReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestRateStreamReference> getType() {
		return InterestRateStreamReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRateStreamReferenceBuilder extends InterestRateStreamReference, Reference.ReferenceBuilder {
		InterestRateStreamReference.InterestRateStreamReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		InterestRateStreamReference.InterestRateStreamReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of InterestRateStreamReference  ***********************/
	class InterestRateStreamReferenceImpl extends Reference.ReferenceImpl implements InterestRateStreamReference {
		private final String href;
		
		protected InterestRateStreamReferenceImpl(InterestRateStreamReference.InterestRateStreamReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public InterestRateStreamReference build() {
			return this;
		}
		
		@Override
		public InterestRateStreamReference.InterestRateStreamReferenceBuilder toBuilder() {
			InterestRateStreamReference.InterestRateStreamReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRateStreamReference.InterestRateStreamReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestRateStreamReference _that = getType().cast(o);
		
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
			return "InterestRateStreamReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestRateStreamReference  ***********************/
	class InterestRateStreamReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements InterestRateStreamReference.InterestRateStreamReferenceBuilder {
	
		protected String href;
	
		public InterestRateStreamReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public InterestRateStreamReference.InterestRateStreamReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public InterestRateStreamReference build() {
			return new InterestRateStreamReference.InterestRateStreamReferenceImpl(this);
		}
		
		@Override
		public InterestRateStreamReference.InterestRateStreamReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateStreamReference.InterestRateStreamReferenceBuilder prune() {
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
		public InterestRateStreamReference.InterestRateStreamReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InterestRateStreamReference.InterestRateStreamReferenceBuilder o = (InterestRateStreamReference.InterestRateStreamReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestRateStreamReference _that = getType().cast(o);
		
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
			return "InterestRateStreamReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
