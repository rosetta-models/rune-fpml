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
import fpml.confirmation.NotionalAmountReference;
import fpml.confirmation.NotionalAmountReference.NotionalAmountReferenceBuilder;
import fpml.confirmation.NotionalAmountReference.NotionalAmountReferenceBuilderImpl;
import fpml.confirmation.NotionalAmountReference.NotionalAmountReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.NotionalAmountReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference to the notional amount.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="NotionalAmountReference", builder=NotionalAmountReference.NotionalAmountReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface NotionalAmountReference extends Reference {

	NotionalAmountReferenceMeta metaData = new NotionalAmountReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	NotionalAmountReference build();
	
	NotionalAmountReference.NotionalAmountReferenceBuilder toBuilder();
	
	static NotionalAmountReference.NotionalAmountReferenceBuilder builder() {
		return new NotionalAmountReference.NotionalAmountReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalAmountReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NotionalAmountReference> getType() {
		return NotionalAmountReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalAmountReferenceBuilder extends NotionalAmountReference, Reference.ReferenceBuilder {
		NotionalAmountReference.NotionalAmountReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		NotionalAmountReference.NotionalAmountReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of NotionalAmountReference  ***********************/
	class NotionalAmountReferenceImpl extends Reference.ReferenceImpl implements NotionalAmountReference {
		private final String href;
		
		protected NotionalAmountReferenceImpl(NotionalAmountReference.NotionalAmountReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public NotionalAmountReference build() {
			return this;
		}
		
		@Override
		public NotionalAmountReference.NotionalAmountReferenceBuilder toBuilder() {
			NotionalAmountReference.NotionalAmountReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalAmountReference.NotionalAmountReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NotionalAmountReference _that = getType().cast(o);
		
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
			return "NotionalAmountReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NotionalAmountReference  ***********************/
	class NotionalAmountReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements NotionalAmountReference.NotionalAmountReferenceBuilder {
	
		protected String href;
	
		public NotionalAmountReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public NotionalAmountReference.NotionalAmountReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public NotionalAmountReference build() {
			return new NotionalAmountReference.NotionalAmountReferenceImpl(this);
		}
		
		@Override
		public NotionalAmountReference.NotionalAmountReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalAmountReference.NotionalAmountReferenceBuilder prune() {
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
		public NotionalAmountReference.NotionalAmountReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NotionalAmountReference.NotionalAmountReferenceBuilder o = (NotionalAmountReference.NotionalAmountReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NotionalAmountReference _that = getType().cast(o);
		
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
			return "NotionalAmountReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
