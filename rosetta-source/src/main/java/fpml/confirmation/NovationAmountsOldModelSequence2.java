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
import fpml.confirmation.NovationAmountsOldModelSequence2;
import fpml.confirmation.NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder;
import fpml.confirmation.NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2BuilderImpl;
import fpml.confirmation.NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Impl;
import fpml.confirmation.meta.NovationAmountsOldModelSequence2Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NovationAmountsOldModelSequence2", builder=NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2BuilderImpl.class, version="${project.version}")
public interface NovationAmountsOldModelSequence2 extends RosettaModelObject {

	NovationAmountsOldModelSequence2Meta metaData = new NovationAmountsOldModelSequence2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of options which represent the portion of the Old Contract being novated.
	 */
	BigDecimal getNovatedNumberOfUnits();
	/**
	 * The number of options which represent the portion of the Old Contract not being novated.
	 */
	BigDecimal getRemainingNumberOfUnits();

	/*********************** Build Methods  ***********************/
	NovationAmountsOldModelSequence2 build();
	
	NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder toBuilder();
	
	static NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder builder() {
		return new NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NovationAmountsOldModelSequence2> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NovationAmountsOldModelSequence2> getType() {
		return NovationAmountsOldModelSequence2.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("novatedNumberOfUnits"), BigDecimal.class, getNovatedNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("remainingNumberOfUnits"), BigDecimal.class, getRemainingNumberOfUnits(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NovationAmountsOldModelSequence2Builder extends NovationAmountsOldModelSequence2, RosettaModelObjectBuilder {
		NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder setNovatedNumberOfUnits(BigDecimal novatedNumberOfUnits);
		NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder setRemainingNumberOfUnits(BigDecimal remainingNumberOfUnits);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("novatedNumberOfUnits"), BigDecimal.class, getNovatedNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("remainingNumberOfUnits"), BigDecimal.class, getRemainingNumberOfUnits(), this);
		}
		

		NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder prune();
	}

	/*********************** Immutable Implementation of NovationAmountsOldModelSequence2  ***********************/
	class NovationAmountsOldModelSequence2Impl implements NovationAmountsOldModelSequence2 {
		private final BigDecimal novatedNumberOfUnits;
		private final BigDecimal remainingNumberOfUnits;
		
		protected NovationAmountsOldModelSequence2Impl(NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder builder) {
			this.novatedNumberOfUnits = builder.getNovatedNumberOfUnits();
			this.remainingNumberOfUnits = builder.getRemainingNumberOfUnits();
		}
		
		@Override
		@RosettaAttribute("novatedNumberOfUnits")
		public BigDecimal getNovatedNumberOfUnits() {
			return novatedNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("remainingNumberOfUnits")
		public BigDecimal getRemainingNumberOfUnits() {
			return remainingNumberOfUnits;
		}
		
		@Override
		public NovationAmountsOldModelSequence2 build() {
			return this;
		}
		
		@Override
		public NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder toBuilder() {
			NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder builder) {
			ofNullable(getNovatedNumberOfUnits()).ifPresent(builder::setNovatedNumberOfUnits);
			ofNullable(getRemainingNumberOfUnits()).ifPresent(builder::setRemainingNumberOfUnits);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationAmountsOldModelSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(novatedNumberOfUnits, _that.getNovatedNumberOfUnits())) return false;
			if (!Objects.equals(remainingNumberOfUnits, _that.getRemainingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novatedNumberOfUnits != null ? novatedNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (remainingNumberOfUnits != null ? remainingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationAmountsOldModelSequence2 {" +
				"novatedNumberOfUnits=" + this.novatedNumberOfUnits + ", " +
				"remainingNumberOfUnits=" + this.remainingNumberOfUnits +
			'}';
		}
	}

	/*********************** Builder Implementation of NovationAmountsOldModelSequence2  ***********************/
	class NovationAmountsOldModelSequence2BuilderImpl implements NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder {
	
		protected BigDecimal novatedNumberOfUnits;
		protected BigDecimal remainingNumberOfUnits;
	
		public NovationAmountsOldModelSequence2BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("novatedNumberOfUnits")
		public BigDecimal getNovatedNumberOfUnits() {
			return novatedNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("remainingNumberOfUnits")
		public BigDecimal getRemainingNumberOfUnits() {
			return remainingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("novatedNumberOfUnits")
		public NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder setNovatedNumberOfUnits(BigDecimal novatedNumberOfUnits) {
			this.novatedNumberOfUnits = novatedNumberOfUnits==null?null:novatedNumberOfUnits;
			return this;
		}
		@Override
		@RosettaAttribute("remainingNumberOfUnits")
		public NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder setRemainingNumberOfUnits(BigDecimal remainingNumberOfUnits) {
			this.remainingNumberOfUnits = remainingNumberOfUnits==null?null:remainingNumberOfUnits;
			return this;
		}
		
		@Override
		public NovationAmountsOldModelSequence2 build() {
			return new NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Impl(this);
		}
		
		@Override
		public NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNovatedNumberOfUnits()!=null) return true;
			if (getRemainingNumberOfUnits()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder o = (NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder) other;
			
			
			merger.mergeBasic(getNovatedNumberOfUnits(), o.getNovatedNumberOfUnits(), this::setNovatedNumberOfUnits);
			merger.mergeBasic(getRemainingNumberOfUnits(), o.getRemainingNumberOfUnits(), this::setRemainingNumberOfUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationAmountsOldModelSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(novatedNumberOfUnits, _that.getNovatedNumberOfUnits())) return false;
			if (!Objects.equals(remainingNumberOfUnits, _that.getRemainingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novatedNumberOfUnits != null ? novatedNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (remainingNumberOfUnits != null ? remainingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationAmountsOldModelSequence2Builder {" +
				"novatedNumberOfUnits=" + this.novatedNumberOfUnits + ", " +
				"remainingNumberOfUnits=" + this.remainingNumberOfUnits +
			'}';
		}
	}
}
