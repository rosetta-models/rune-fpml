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
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.LoanAllocationReference.LoanAllocationReferenceBuilder;
import fpml.confirmation.LoanAllocationReference.LoanAllocationReferenceBuilderImpl;
import fpml.confirmation.LoanAllocationReference.LoanAllocationReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.LoanAllocationReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference to a loan trade allocation.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationReference", builder=LoanAllocationReference.LoanAllocationReferenceBuilderImpl.class, version="${project.version}")
public interface LoanAllocationReference extends Reference {

	LoanAllocationReferenceMeta metaData = new LoanAllocationReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	LoanAllocationReference build();
	
	LoanAllocationReference.LoanAllocationReferenceBuilder toBuilder();
	
	static LoanAllocationReference.LoanAllocationReferenceBuilder builder() {
		return new LoanAllocationReference.LoanAllocationReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationReference> getType() {
		return LoanAllocationReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationReferenceBuilder extends LoanAllocationReference, Reference.ReferenceBuilder {
		LoanAllocationReference.LoanAllocationReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		LoanAllocationReference.LoanAllocationReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationReference  ***********************/
	class LoanAllocationReferenceImpl extends Reference.ReferenceImpl implements LoanAllocationReference {
		private final String href;
		
		protected LoanAllocationReferenceImpl(LoanAllocationReference.LoanAllocationReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public LoanAllocationReference build() {
			return this;
		}
		
		@Override
		public LoanAllocationReference.LoanAllocationReferenceBuilder toBuilder() {
			LoanAllocationReference.LoanAllocationReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationReference.LoanAllocationReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationReference _that = getType().cast(o);
		
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
			return "LoanAllocationReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationReference  ***********************/
	class LoanAllocationReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements LoanAllocationReference.LoanAllocationReferenceBuilder {
	
		protected String href;
	
		public LoanAllocationReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public LoanAllocationReference.LoanAllocationReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public LoanAllocationReference build() {
			return new LoanAllocationReference.LoanAllocationReferenceImpl(this);
		}
		
		@Override
		public LoanAllocationReference.LoanAllocationReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationReference.LoanAllocationReferenceBuilder prune() {
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
		public LoanAllocationReference.LoanAllocationReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationReference.LoanAllocationReferenceBuilder o = (LoanAllocationReference.LoanAllocationReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationReference _that = getType().cast(o);
		
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
			return "LoanAllocationReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
