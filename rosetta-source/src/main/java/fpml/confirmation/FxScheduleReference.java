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
import fpml.confirmation.FxScheduleReference;
import fpml.confirmation.FxScheduleReference.FxScheduleReferenceBuilder;
import fpml.confirmation.FxScheduleReference.FxScheduleReferenceBuilderImpl;
import fpml.confirmation.FxScheduleReference.FxScheduleReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxScheduleReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a FX Schedule structure.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxScheduleReference", builder=FxScheduleReference.FxScheduleReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxScheduleReference extends Reference {

	FxScheduleReferenceMeta metaData = new FxScheduleReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxScheduleReference build();
	
	FxScheduleReference.FxScheduleReferenceBuilder toBuilder();
	
	static FxScheduleReference.FxScheduleReferenceBuilder builder() {
		return new FxScheduleReference.FxScheduleReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxScheduleReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxScheduleReference> getType() {
		return FxScheduleReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxScheduleReferenceBuilder extends FxScheduleReference, Reference.ReferenceBuilder {
		FxScheduleReference.FxScheduleReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxScheduleReference.FxScheduleReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxScheduleReference  ***********************/
	class FxScheduleReferenceImpl extends Reference.ReferenceImpl implements FxScheduleReference {
		private final String href;
		
		protected FxScheduleReferenceImpl(FxScheduleReference.FxScheduleReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxScheduleReference build() {
			return this;
		}
		
		@Override
		public FxScheduleReference.FxScheduleReferenceBuilder toBuilder() {
			FxScheduleReference.FxScheduleReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxScheduleReference.FxScheduleReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxScheduleReference _that = getType().cast(o);
		
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
			return "FxScheduleReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxScheduleReference  ***********************/
	class FxScheduleReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxScheduleReference.FxScheduleReferenceBuilder {
	
		protected String href;
	
		public FxScheduleReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxScheduleReference.FxScheduleReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxScheduleReference build() {
			return new FxScheduleReference.FxScheduleReferenceImpl(this);
		}
		
		@Override
		public FxScheduleReference.FxScheduleReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxScheduleReference.FxScheduleReferenceBuilder prune() {
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
		public FxScheduleReference.FxScheduleReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxScheduleReference.FxScheduleReferenceBuilder o = (FxScheduleReference.FxScheduleReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxScheduleReference _that = getType().cast(o);
		
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
			return "FxScheduleReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
