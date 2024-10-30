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
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.ResetDatesReference;
import fpml.confirmation.ResetDatesReference.ResetDatesReferenceBuilder;
import fpml.confirmation.ResetDatesReference.ResetDatesReferenceBuilderImpl;
import fpml.confirmation.ResetDatesReference.ResetDatesReferenceImpl;
import fpml.confirmation.meta.ResetDatesReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a reset dates component.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ResetDatesReference", builder=ResetDatesReference.ResetDatesReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ResetDatesReference extends Reference {

	ResetDatesReferenceMeta metaData = new ResetDatesReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	ResetDatesReference build();
	
	ResetDatesReference.ResetDatesReferenceBuilder toBuilder();
	
	static ResetDatesReference.ResetDatesReferenceBuilder builder() {
		return new ResetDatesReference.ResetDatesReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResetDatesReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ResetDatesReference> getType() {
		return ResetDatesReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResetDatesReferenceBuilder extends ResetDatesReference, Reference.ReferenceBuilder {
		ResetDatesReference.ResetDatesReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		ResetDatesReference.ResetDatesReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of ResetDatesReference  ***********************/
	class ResetDatesReferenceImpl extends Reference.ReferenceImpl implements ResetDatesReference {
		private final String href;
		
		protected ResetDatesReferenceImpl(ResetDatesReference.ResetDatesReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public ResetDatesReference build() {
			return this;
		}
		
		@Override
		public ResetDatesReference.ResetDatesReferenceBuilder toBuilder() {
			ResetDatesReference.ResetDatesReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetDatesReference.ResetDatesReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResetDatesReference _that = getType().cast(o);
		
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
			return "ResetDatesReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ResetDatesReference  ***********************/
	class ResetDatesReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements ResetDatesReference.ResetDatesReferenceBuilder {
	
		protected String href;
	
		public ResetDatesReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public ResetDatesReference.ResetDatesReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public ResetDatesReference build() {
			return new ResetDatesReference.ResetDatesReferenceImpl(this);
		}
		
		@Override
		public ResetDatesReference.ResetDatesReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetDatesReference.ResetDatesReferenceBuilder prune() {
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
		public ResetDatesReference.ResetDatesReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ResetDatesReference.ResetDatesReferenceBuilder o = (ResetDatesReference.ResetDatesReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResetDatesReference _that = getType().cast(o);
		
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
			return "ResetDatesReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
