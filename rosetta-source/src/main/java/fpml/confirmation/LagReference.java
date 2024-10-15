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
import fpml.confirmation.LagReference;
import fpml.confirmation.LagReference.LagReferenceBuilder;
import fpml.confirmation.LagReference.LagReferenceBuilderImpl;
import fpml.confirmation.LagReference.LagReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.LagReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Allows a lag to reference one already defined elsewhere in the trade.
 * @version ${project.version}
 */
@RosettaDataType(value="LagReference", builder=LagReference.LagReferenceBuilderImpl.class, version="${project.version}")
public interface LagReference extends Reference {

	LagReferenceMeta metaData = new LagReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	LagReference build();
	
	LagReference.LagReferenceBuilder toBuilder();
	
	static LagReference.LagReferenceBuilder builder() {
		return new LagReference.LagReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LagReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LagReference> getType() {
		return LagReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LagReferenceBuilder extends LagReference, Reference.ReferenceBuilder {
		LagReference.LagReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		LagReference.LagReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of LagReference  ***********************/
	class LagReferenceImpl extends Reference.ReferenceImpl implements LagReference {
		private final String href;
		
		protected LagReferenceImpl(LagReference.LagReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public LagReference build() {
			return this;
		}
		
		@Override
		public LagReference.LagReferenceBuilder toBuilder() {
			LagReference.LagReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LagReference.LagReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LagReference _that = getType().cast(o);
		
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
			return "LagReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LagReference  ***********************/
	class LagReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements LagReference.LagReferenceBuilder {
	
		protected String href;
	
		public LagReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public LagReference.LagReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public LagReference build() {
			return new LagReference.LagReferenceImpl(this);
		}
		
		@Override
		public LagReference.LagReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LagReference.LagReferenceBuilder prune() {
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
		public LagReference.LagReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LagReference.LagReferenceBuilder o = (LagReference.LagReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LagReference _that = getType().cast(o);
		
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
			return "LagReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
