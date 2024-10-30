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
import fpml.confirmation.AmountReference;
import fpml.confirmation.AmountReference.AmountReferenceBuilder;
import fpml.confirmation.AmountReference.AmountReferenceBuilderImpl;
import fpml.confirmation.AmountReference.AmountReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.AmountReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies a reference to a monetary amount.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AmountReference", builder=AmountReference.AmountReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AmountReference extends Reference {

	AmountReferenceMeta metaData = new AmountReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	AmountReference build();
	
	AmountReference.AmountReferenceBuilder toBuilder();
	
	static AmountReference.AmountReferenceBuilder builder() {
		return new AmountReference.AmountReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmountReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AmountReference> getType() {
		return AmountReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AmountReferenceBuilder extends AmountReference, Reference.ReferenceBuilder {
		AmountReference.AmountReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		AmountReference.AmountReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of AmountReference  ***********************/
	class AmountReferenceImpl extends Reference.ReferenceImpl implements AmountReference {
		private final String href;
		
		protected AmountReferenceImpl(AmountReference.AmountReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public AmountReference build() {
			return this;
		}
		
		@Override
		public AmountReference.AmountReferenceBuilder toBuilder() {
			AmountReference.AmountReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmountReference.AmountReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AmountReference _that = getType().cast(o);
		
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
			return "AmountReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AmountReference  ***********************/
	class AmountReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements AmountReference.AmountReferenceBuilder {
	
		protected String href;
	
		public AmountReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public AmountReference.AmountReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public AmountReference build() {
			return new AmountReference.AmountReferenceImpl(this);
		}
		
		@Override
		public AmountReference.AmountReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountReference.AmountReferenceBuilder prune() {
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
		public AmountReference.AmountReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AmountReference.AmountReferenceBuilder o = (AmountReference.AmountReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AmountReference _that = getType().cast(o);
		
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
			return "AmountReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
