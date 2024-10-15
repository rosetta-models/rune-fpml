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
import fpml.confirmation.NotionalReference;
import fpml.confirmation.NotionalReference.NotionalReferenceBuilder;
import fpml.confirmation.NotionalReference.NotionalReferenceBuilderImpl;
import fpml.confirmation.NotionalReference.NotionalReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.NotionalReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference to the notional amount.
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalReference", builder=NotionalReference.NotionalReferenceBuilderImpl.class, version="${project.version}")
public interface NotionalReference extends Reference {

	NotionalReferenceMeta metaData = new NotionalReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	NotionalReference build();
	
	NotionalReference.NotionalReferenceBuilder toBuilder();
	
	static NotionalReference.NotionalReferenceBuilder builder() {
		return new NotionalReference.NotionalReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NotionalReference> getType() {
		return NotionalReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalReferenceBuilder extends NotionalReference, Reference.ReferenceBuilder {
		NotionalReference.NotionalReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		NotionalReference.NotionalReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of NotionalReference  ***********************/
	class NotionalReferenceImpl extends Reference.ReferenceImpl implements NotionalReference {
		private final String href;
		
		protected NotionalReferenceImpl(NotionalReference.NotionalReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public NotionalReference build() {
			return this;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder toBuilder() {
			NotionalReference.NotionalReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalReference.NotionalReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NotionalReference _that = getType().cast(o);
		
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
			return "NotionalReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NotionalReference  ***********************/
	class NotionalReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements NotionalReference.NotionalReferenceBuilder {
	
		protected String href;
	
		public NotionalReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public NotionalReference.NotionalReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public NotionalReference build() {
			return new NotionalReference.NotionalReferenceImpl(this);
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalReference.NotionalReferenceBuilder prune() {
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
		public NotionalReference.NotionalReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NotionalReference.NotionalReferenceBuilder o = (NotionalReference.NotionalReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NotionalReference _that = getType().cast(o);
		
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
			return "NotionalReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
