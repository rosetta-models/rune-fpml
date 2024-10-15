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
import fpml.confirmation.FxStrikeReference;
import fpml.confirmation.FxStrikeReference.FxStrikeReferenceBuilder;
import fpml.confirmation.FxStrikeReference.FxStrikeReferenceBuilderImpl;
import fpml.confirmation.FxStrikeReference.FxStrikeReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxStrikeReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a strike structure.
 * @version ${project.version}
 */
@RosettaDataType(value="FxStrikeReference", builder=FxStrikeReference.FxStrikeReferenceBuilderImpl.class, version="${project.version}")
public interface FxStrikeReference extends Reference {

	FxStrikeReferenceMeta metaData = new FxStrikeReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxStrikeReference build();
	
	FxStrikeReference.FxStrikeReferenceBuilder toBuilder();
	
	static FxStrikeReference.FxStrikeReferenceBuilder builder() {
		return new FxStrikeReference.FxStrikeReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxStrikeReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxStrikeReference> getType() {
		return FxStrikeReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxStrikeReferenceBuilder extends FxStrikeReference, Reference.ReferenceBuilder {
		FxStrikeReference.FxStrikeReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxStrikeReference.FxStrikeReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxStrikeReference  ***********************/
	class FxStrikeReferenceImpl extends Reference.ReferenceImpl implements FxStrikeReference {
		private final String href;
		
		protected FxStrikeReferenceImpl(FxStrikeReference.FxStrikeReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxStrikeReference build() {
			return this;
		}
		
		@Override
		public FxStrikeReference.FxStrikeReferenceBuilder toBuilder() {
			FxStrikeReference.FxStrikeReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxStrikeReference.FxStrikeReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxStrikeReference _that = getType().cast(o);
		
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
			return "FxStrikeReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxStrikeReference  ***********************/
	class FxStrikeReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxStrikeReference.FxStrikeReferenceBuilder {
	
		protected String href;
	
		public FxStrikeReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxStrikeReference.FxStrikeReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxStrikeReference build() {
			return new FxStrikeReference.FxStrikeReferenceImpl(this);
		}
		
		@Override
		public FxStrikeReference.FxStrikeReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStrikeReference.FxStrikeReferenceBuilder prune() {
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
		public FxStrikeReference.FxStrikeReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxStrikeReference.FxStrikeReferenceBuilder o = (FxStrikeReference.FxStrikeReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxStrikeReference _that = getType().cast(o);
		
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
			return "FxStrikeReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
