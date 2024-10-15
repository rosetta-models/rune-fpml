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
import fpml.confirmation.FxAccrualTriggerReference;
import fpml.confirmation.FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder;
import fpml.confirmation.FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilderImpl;
import fpml.confirmation.FxAccrualTriggerReference.FxAccrualTriggerReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxAccrualTriggerReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a trigger structure in FxAccrualDigitalOption product.
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualTriggerReference", builder=FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilderImpl.class, version="${project.version}")
public interface FxAccrualTriggerReference extends Reference {

	FxAccrualTriggerReferenceMeta metaData = new FxAccrualTriggerReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxAccrualTriggerReference build();
	
	FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder toBuilder();
	
	static FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder builder() {
		return new FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualTriggerReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualTriggerReference> getType() {
		return FxAccrualTriggerReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualTriggerReferenceBuilder extends FxAccrualTriggerReference, Reference.ReferenceBuilder {
		FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualTriggerReference  ***********************/
	class FxAccrualTriggerReferenceImpl extends Reference.ReferenceImpl implements FxAccrualTriggerReference {
		private final String href;
		
		protected FxAccrualTriggerReferenceImpl(FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxAccrualTriggerReference build() {
			return this;
		}
		
		@Override
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder toBuilder() {
			FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualTriggerReference _that = getType().cast(o);
		
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
			return "FxAccrualTriggerReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualTriggerReference  ***********************/
	class FxAccrualTriggerReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder {
	
		protected String href;
	
		public FxAccrualTriggerReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxAccrualTriggerReference build() {
			return new FxAccrualTriggerReference.FxAccrualTriggerReferenceImpl(this);
		}
		
		@Override
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder prune() {
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
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder o = (FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualTriggerReference _that = getType().cast(o);
		
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
			return "FxAccrualTriggerReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
