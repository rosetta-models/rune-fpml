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
import fpml.confirmation.FxAccrualAverageStrikeReference;
import fpml.confirmation.FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder;
import fpml.confirmation.FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilderImpl;
import fpml.confirmation.FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxAccrualAverageStrikeReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to an average rate structure in FxAccrualForward or FxAccrualOption products.
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualAverageStrikeReference", builder=FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilderImpl.class, version="${project.version}")
public interface FxAccrualAverageStrikeReference extends Reference {

	FxAccrualAverageStrikeReferenceMeta metaData = new FxAccrualAverageStrikeReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxAccrualAverageStrikeReference build();
	
	FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder toBuilder();
	
	static FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder builder() {
		return new FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualAverageStrikeReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualAverageStrikeReference> getType() {
		return FxAccrualAverageStrikeReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualAverageStrikeReferenceBuilder extends FxAccrualAverageStrikeReference, Reference.ReferenceBuilder {
		FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualAverageStrikeReference  ***********************/
	class FxAccrualAverageStrikeReferenceImpl extends Reference.ReferenceImpl implements FxAccrualAverageStrikeReference {
		private final String href;
		
		protected FxAccrualAverageStrikeReferenceImpl(FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxAccrualAverageStrikeReference build() {
			return this;
		}
		
		@Override
		public FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder toBuilder() {
			FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualAverageStrikeReference _that = getType().cast(o);
		
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
			return "FxAccrualAverageStrikeReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualAverageStrikeReference  ***********************/
	class FxAccrualAverageStrikeReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder {
	
		protected String href;
	
		public FxAccrualAverageStrikeReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxAccrualAverageStrikeReference build() {
			return new FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceImpl(this);
		}
		
		@Override
		public FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder prune() {
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
		public FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder o = (FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualAverageStrikeReference _that = getType().cast(o);
		
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
			return "FxAccrualAverageStrikeReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
