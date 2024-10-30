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
import fpml.confirmation.ReturnSwapNotionalAmountReference;
import fpml.confirmation.ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder;
import fpml.confirmation.ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilderImpl;
import fpml.confirmation.ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceImpl;
import fpml.confirmation.meta.ReturnSwapNotionalAmountReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference to the return swap notional amount.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ReturnSwapNotionalAmountReference", builder=ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ReturnSwapNotionalAmountReference extends Reference {

	ReturnSwapNotionalAmountReferenceMeta metaData = new ReturnSwapNotionalAmountReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	ReturnSwapNotionalAmountReference build();
	
	ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder toBuilder();
	
	static ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder builder() {
		return new ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapNotionalAmountReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnSwapNotionalAmountReference> getType() {
		return ReturnSwapNotionalAmountReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapNotionalAmountReferenceBuilder extends ReturnSwapNotionalAmountReference, Reference.ReferenceBuilder {
		ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapNotionalAmountReference  ***********************/
	class ReturnSwapNotionalAmountReferenceImpl extends Reference.ReferenceImpl implements ReturnSwapNotionalAmountReference {
		private final String href;
		
		protected ReturnSwapNotionalAmountReferenceImpl(ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public ReturnSwapNotionalAmountReference build() {
			return this;
		}
		
		@Override
		public ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder toBuilder() {
			ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapNotionalAmountReference _that = getType().cast(o);
		
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
			return "ReturnSwapNotionalAmountReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwapNotionalAmountReference  ***********************/
	class ReturnSwapNotionalAmountReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder {
	
		protected String href;
	
		public ReturnSwapNotionalAmountReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public ReturnSwapNotionalAmountReference build() {
			return new ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceImpl(this);
		}
		
		@Override
		public ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder prune() {
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
		public ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder o = (ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapNotionalAmountReference _that = getType().cast(o);
		
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
			return "ReturnSwapNotionalAmountReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
