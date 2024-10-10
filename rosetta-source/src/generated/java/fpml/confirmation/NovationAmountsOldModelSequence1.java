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
import fpml.confirmation.NovationAmountsOldModelSequence1;
import fpml.confirmation.NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder;
import fpml.confirmation.NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1BuilderImpl;
import fpml.confirmation.NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Impl;
import fpml.confirmation.meta.NovationAmountsOldModelSequence1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NovationAmountsOldModelSequence1", builder=NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1BuilderImpl.class, version="${project.version}")
public interface NovationAmountsOldModelSequence1 extends RosettaModelObject {

	NovationAmountsOldModelSequence1Meta metaData = new NovationAmountsOldModelSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of options which represent the portion of the Old Contract being novated.
	 */
	BigDecimal getNovatedNumberOfOptions();
	/**
	 * The number of options which represent the portion of the Old Contract not being novated.
	 */
	BigDecimal getRemainingNumberOfOptions();

	/*********************** Build Methods  ***********************/
	NovationAmountsOldModelSequence1 build();
	
	NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder toBuilder();
	
	static NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder builder() {
		return new NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NovationAmountsOldModelSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NovationAmountsOldModelSequence1> getType() {
		return NovationAmountsOldModelSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("novatedNumberOfOptions"), BigDecimal.class, getNovatedNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("remainingNumberOfOptions"), BigDecimal.class, getRemainingNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NovationAmountsOldModelSequence1Builder extends NovationAmountsOldModelSequence1, RosettaModelObjectBuilder {
		NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder setNovatedNumberOfOptions(BigDecimal novatedNumberOfOptions);
		NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder setRemainingNumberOfOptions(BigDecimal remainingNumberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("novatedNumberOfOptions"), BigDecimal.class, getNovatedNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("remainingNumberOfOptions"), BigDecimal.class, getRemainingNumberOfOptions(), this);
		}
		

		NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder prune();
	}

	/*********************** Immutable Implementation of NovationAmountsOldModelSequence1  ***********************/
	class NovationAmountsOldModelSequence1Impl implements NovationAmountsOldModelSequence1 {
		private final BigDecimal novatedNumberOfOptions;
		private final BigDecimal remainingNumberOfOptions;
		
		protected NovationAmountsOldModelSequence1Impl(NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder builder) {
			this.novatedNumberOfOptions = builder.getNovatedNumberOfOptions();
			this.remainingNumberOfOptions = builder.getRemainingNumberOfOptions();
		}
		
		@Override
		@RosettaAttribute("novatedNumberOfOptions")
		public BigDecimal getNovatedNumberOfOptions() {
			return novatedNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("remainingNumberOfOptions")
		public BigDecimal getRemainingNumberOfOptions() {
			return remainingNumberOfOptions;
		}
		
		@Override
		public NovationAmountsOldModelSequence1 build() {
			return this;
		}
		
		@Override
		public NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder toBuilder() {
			NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder builder) {
			ofNullable(getNovatedNumberOfOptions()).ifPresent(builder::setNovatedNumberOfOptions);
			ofNullable(getRemainingNumberOfOptions()).ifPresent(builder::setRemainingNumberOfOptions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationAmountsOldModelSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(novatedNumberOfOptions, _that.getNovatedNumberOfOptions())) return false;
			if (!Objects.equals(remainingNumberOfOptions, _that.getRemainingNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novatedNumberOfOptions != null ? novatedNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (remainingNumberOfOptions != null ? remainingNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationAmountsOldModelSequence1 {" +
				"novatedNumberOfOptions=" + this.novatedNumberOfOptions + ", " +
				"remainingNumberOfOptions=" + this.remainingNumberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of NovationAmountsOldModelSequence1  ***********************/
	class NovationAmountsOldModelSequence1BuilderImpl implements NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder {
	
		protected BigDecimal novatedNumberOfOptions;
		protected BigDecimal remainingNumberOfOptions;
	
		public NovationAmountsOldModelSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("novatedNumberOfOptions")
		public BigDecimal getNovatedNumberOfOptions() {
			return novatedNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("remainingNumberOfOptions")
		public BigDecimal getRemainingNumberOfOptions() {
			return remainingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("novatedNumberOfOptions")
		public NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder setNovatedNumberOfOptions(BigDecimal novatedNumberOfOptions) {
			this.novatedNumberOfOptions = novatedNumberOfOptions==null?null:novatedNumberOfOptions;
			return this;
		}
		@Override
		@RosettaAttribute("remainingNumberOfOptions")
		public NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder setRemainingNumberOfOptions(BigDecimal remainingNumberOfOptions) {
			this.remainingNumberOfOptions = remainingNumberOfOptions==null?null:remainingNumberOfOptions;
			return this;
		}
		
		@Override
		public NovationAmountsOldModelSequence1 build() {
			return new NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Impl(this);
		}
		
		@Override
		public NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNovatedNumberOfOptions()!=null) return true;
			if (getRemainingNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder o = (NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder) other;
			
			
			merger.mergeBasic(getNovatedNumberOfOptions(), o.getNovatedNumberOfOptions(), this::setNovatedNumberOfOptions);
			merger.mergeBasic(getRemainingNumberOfOptions(), o.getRemainingNumberOfOptions(), this::setRemainingNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationAmountsOldModelSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(novatedNumberOfOptions, _that.getNovatedNumberOfOptions())) return false;
			if (!Objects.equals(remainingNumberOfOptions, _that.getRemainingNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novatedNumberOfOptions != null ? novatedNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (remainingNumberOfOptions != null ? remainingNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationAmountsOldModelSequence1Builder {" +
				"novatedNumberOfOptions=" + this.novatedNumberOfOptions + ", " +
				"remainingNumberOfOptions=" + this.remainingNumberOfOptions +
			'}';
		}
	}
}
