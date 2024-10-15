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
import fpml.confirmation.BasketReferenceInformationSequence;
import fpml.confirmation.BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder;
import fpml.confirmation.BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilderImpl;
import fpml.confirmation.BasketReferenceInformationSequence.BasketReferenceInformationSequenceImpl;
import fpml.confirmation.meta.BasketReferenceInformationSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="BasketReferenceInformationSequence", builder=BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilderImpl.class, version="${project.version}")
public interface BasketReferenceInformationSequence extends RosettaModelObject {

	BasketReferenceInformationSequenceMeta metaData = new BasketReferenceInformationSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * N th reference obligation to default triggers payout.
	 */
	Integer getNthToDefault();
	/**
	 * M th reference obligation to default to allow representation of N th to M th defaults.
	 */
	Integer getMthToDefault();

	/*********************** Build Methods  ***********************/
	BasketReferenceInformationSequence build();
	
	BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder toBuilder();
	
	static BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder builder() {
		return new BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketReferenceInformationSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BasketReferenceInformationSequence> getType() {
		return BasketReferenceInformationSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nthToDefault"), Integer.class, getNthToDefault(), this);
		processor.processBasic(path.newSubPath("mthToDefault"), Integer.class, getMthToDefault(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketReferenceInformationSequenceBuilder extends BasketReferenceInformationSequence, RosettaModelObjectBuilder {
		BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder setNthToDefault(Integer nthToDefault);
		BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder setMthToDefault(Integer mthToDefault);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("nthToDefault"), Integer.class, getNthToDefault(), this);
			processor.processBasic(path.newSubPath("mthToDefault"), Integer.class, getMthToDefault(), this);
		}
		

		BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of BasketReferenceInformationSequence  ***********************/
	class BasketReferenceInformationSequenceImpl implements BasketReferenceInformationSequence {
		private final Integer nthToDefault;
		private final Integer mthToDefault;
		
		protected BasketReferenceInformationSequenceImpl(BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder builder) {
			this.nthToDefault = builder.getNthToDefault();
			this.mthToDefault = builder.getMthToDefault();
		}
		
		@Override
		@RosettaAttribute("nthToDefault")
		public Integer getNthToDefault() {
			return nthToDefault;
		}
		
		@Override
		@RosettaAttribute("mthToDefault")
		public Integer getMthToDefault() {
			return mthToDefault;
		}
		
		@Override
		public BasketReferenceInformationSequence build() {
			return this;
		}
		
		@Override
		public BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder toBuilder() {
			BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder builder) {
			ofNullable(getNthToDefault()).ifPresent(builder::setNthToDefault);
			ofNullable(getMthToDefault()).ifPresent(builder::setMthToDefault);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketReferenceInformationSequence _that = getType().cast(o);
		
			if (!Objects.equals(nthToDefault, _that.getNthToDefault())) return false;
			if (!Objects.equals(mthToDefault, _that.getMthToDefault())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nthToDefault != null ? nthToDefault.hashCode() : 0);
			_result = 31 * _result + (mthToDefault != null ? mthToDefault.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketReferenceInformationSequence {" +
				"nthToDefault=" + this.nthToDefault + ", " +
				"mthToDefault=" + this.mthToDefault +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketReferenceInformationSequence  ***********************/
	class BasketReferenceInformationSequenceBuilderImpl implements BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder {
	
		protected Integer nthToDefault;
		protected Integer mthToDefault;
	
		public BasketReferenceInformationSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("nthToDefault")
		public Integer getNthToDefault() {
			return nthToDefault;
		}
		
		@Override
		@RosettaAttribute("mthToDefault")
		public Integer getMthToDefault() {
			return mthToDefault;
		}
		
		@Override
		@RosettaAttribute("nthToDefault")
		public BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder setNthToDefault(Integer nthToDefault) {
			this.nthToDefault = nthToDefault==null?null:nthToDefault;
			return this;
		}
		@Override
		@RosettaAttribute("mthToDefault")
		public BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder setMthToDefault(Integer mthToDefault) {
			this.mthToDefault = mthToDefault==null?null:mthToDefault;
			return this;
		}
		
		@Override
		public BasketReferenceInformationSequence build() {
			return new BasketReferenceInformationSequence.BasketReferenceInformationSequenceImpl(this);
		}
		
		@Override
		public BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNthToDefault()!=null) return true;
			if (getMthToDefault()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder o = (BasketReferenceInformationSequence.BasketReferenceInformationSequenceBuilder) other;
			
			
			merger.mergeBasic(getNthToDefault(), o.getNthToDefault(), this::setNthToDefault);
			merger.mergeBasic(getMthToDefault(), o.getMthToDefault(), this::setMthToDefault);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketReferenceInformationSequence _that = getType().cast(o);
		
			if (!Objects.equals(nthToDefault, _that.getNthToDefault())) return false;
			if (!Objects.equals(mthToDefault, _that.getMthToDefault())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nthToDefault != null ? nthToDefault.hashCode() : 0);
			_result = 31 * _result + (mthToDefault != null ? mthToDefault.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketReferenceInformationSequenceBuilder {" +
				"nthToDefault=" + this.nthToDefault + ", " +
				"mthToDefault=" + this.mthToDefault +
			'}';
		}
	}
}
