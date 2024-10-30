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
import fpml.confirmation.RateReference;
import fpml.confirmation.RateReference.RateReferenceBuilder;
import fpml.confirmation.RateReference.RateReferenceBuilderImpl;
import fpml.confirmation.RateReference.RateReferenceImpl;
import fpml.confirmation.meta.RateReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to any rate (floating, inflation) derived from the abstract Rate component.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RateReference", builder=RateReference.RateReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RateReference extends RosettaModelObject {

	RateReferenceMeta metaData = new RateReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	RateReference build();
	
	RateReference.RateReferenceBuilder toBuilder();
	
	static RateReference.RateReferenceBuilder builder() {
		return new RateReference.RateReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RateReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RateReference> getType() {
		return RateReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RateReferenceBuilder extends RateReference, RosettaModelObjectBuilder {
		RateReference.RateReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		RateReference.RateReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of RateReference  ***********************/
	class RateReferenceImpl implements RateReference {
		private final String href;
		
		protected RateReferenceImpl(RateReference.RateReferenceBuilder builder) {
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public RateReference build() {
			return this;
		}
		
		@Override
		public RateReference.RateReferenceBuilder toBuilder() {
			RateReference.RateReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RateReference.RateReferenceBuilder builder) {
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateReference {" +
				"href=" + this.href +
			'}';
		}
	}

	/*********************** Builder Implementation of RateReference  ***********************/
	class RateReferenceBuilderImpl implements RateReference.RateReferenceBuilder {
	
		protected String href;
	
		public RateReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public RateReference.RateReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public RateReference build() {
			return new RateReference.RateReferenceImpl(this);
		}
		
		@Override
		public RateReference.RateReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateReference.RateReferenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateReference.RateReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RateReference.RateReferenceBuilder o = (RateReference.RateReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateReferenceBuilder {" +
				"href=" + this.href +
			'}';
		}
	}
}
