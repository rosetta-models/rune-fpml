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
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.LoanContractReference.LoanContractReferenceBuilder;
import fpml.confirmation.LoanContractReference.LoanContractReferenceBuilderImpl;
import fpml.confirmation.LoanContractReference.LoanContractReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.LoanContractReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference to a loan contract.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanContractReference", builder=LoanContractReference.LoanContractReferenceBuilderImpl.class, version="${project.version}")
public interface LoanContractReference extends Reference {

	LoanContractReferenceMeta metaData = new LoanContractReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	LoanContractReference build();
	
	LoanContractReference.LoanContractReferenceBuilder toBuilder();
	
	static LoanContractReference.LoanContractReferenceBuilder builder() {
		return new LoanContractReference.LoanContractReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanContractReference> getType() {
		return LoanContractReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractReferenceBuilder extends LoanContractReference, Reference.ReferenceBuilder {
		LoanContractReference.LoanContractReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		LoanContractReference.LoanContractReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractReference  ***********************/
	class LoanContractReferenceImpl extends Reference.ReferenceImpl implements LoanContractReference {
		private final String href;
		
		protected LoanContractReferenceImpl(LoanContractReference.LoanContractReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public LoanContractReference build() {
			return this;
		}
		
		@Override
		public LoanContractReference.LoanContractReferenceBuilder toBuilder() {
			LoanContractReference.LoanContractReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractReference.LoanContractReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractReference _that = getType().cast(o);
		
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
			return "LoanContractReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContractReference  ***********************/
	class LoanContractReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements LoanContractReference.LoanContractReferenceBuilder {
	
		protected String href;
	
		public LoanContractReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public LoanContractReference.LoanContractReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public LoanContractReference build() {
			return new LoanContractReference.LoanContractReferenceImpl(this);
		}
		
		@Override
		public LoanContractReference.LoanContractReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractReference.LoanContractReferenceBuilder prune() {
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
		public LoanContractReference.LoanContractReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanContractReference.LoanContractReferenceBuilder o = (LoanContractReference.LoanContractReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractReference _that = getType().cast(o);
		
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
			return "LoanContractReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
