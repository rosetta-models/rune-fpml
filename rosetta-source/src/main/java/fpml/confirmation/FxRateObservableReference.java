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
import fpml.confirmation.FxRateObservableReference;
import fpml.confirmation.FxRateObservableReference.FxRateObservableReferenceBuilder;
import fpml.confirmation.FxRateObservableReference.FxRateObservableReferenceBuilderImpl;
import fpml.confirmation.FxRateObservableReference.FxRateObservableReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxRateObservableReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to an &quot;FxRateObservable&quot; structure.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxRateObservableReference", builder=FxRateObservableReference.FxRateObservableReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxRateObservableReference extends Reference {

	FxRateObservableReferenceMeta metaData = new FxRateObservableReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxRateObservableReference build();
	
	FxRateObservableReference.FxRateObservableReferenceBuilder toBuilder();
	
	static FxRateObservableReference.FxRateObservableReferenceBuilder builder() {
		return new FxRateObservableReference.FxRateObservableReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxRateObservableReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxRateObservableReference> getType() {
		return FxRateObservableReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxRateObservableReferenceBuilder extends FxRateObservableReference, Reference.ReferenceBuilder {
		FxRateObservableReference.FxRateObservableReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxRateObservableReference.FxRateObservableReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxRateObservableReference  ***********************/
	class FxRateObservableReferenceImpl extends Reference.ReferenceImpl implements FxRateObservableReference {
		private final String href;
		
		protected FxRateObservableReferenceImpl(FxRateObservableReference.FxRateObservableReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxRateObservableReference build() {
			return this;
		}
		
		@Override
		public FxRateObservableReference.FxRateObservableReferenceBuilder toBuilder() {
			FxRateObservableReference.FxRateObservableReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxRateObservableReference.FxRateObservableReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxRateObservableReference _that = getType().cast(o);
		
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
			return "FxRateObservableReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxRateObservableReference  ***********************/
	class FxRateObservableReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxRateObservableReference.FxRateObservableReferenceBuilder {
	
		protected String href;
	
		public FxRateObservableReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxRateObservableReference.FxRateObservableReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxRateObservableReference build() {
			return new FxRateObservableReference.FxRateObservableReferenceImpl(this);
		}
		
		@Override
		public FxRateObservableReference.FxRateObservableReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxRateObservableReference.FxRateObservableReferenceBuilder prune() {
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
		public FxRateObservableReference.FxRateObservableReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxRateObservableReference.FxRateObservableReferenceBuilder o = (FxRateObservableReference.FxRateObservableReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxRateObservableReference _that = getType().cast(o);
		
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
			return "FxRateObservableReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
