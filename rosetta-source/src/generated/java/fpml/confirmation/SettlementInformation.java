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
import fpml.confirmation.SettlementInformation;
import fpml.confirmation.SettlementInformation.SettlementInformationBuilder;
import fpml.confirmation.SettlementInformation.SettlementInformationBuilderImpl;
import fpml.confirmation.SettlementInformation.SettlementInformationImpl;
import fpml.confirmation.SettlementInstruction;
import fpml.confirmation.StandardSettlementStyleEnum;
import fpml.confirmation.meta.SettlementInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that represents the choice of methods for settling a potential currency payment resulting from a trade: by means of a standard settlement instruction, by netting it out with other payments, or with an explicit settlement instruction.
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementInformation", builder=SettlementInformation.SettlementInformationBuilderImpl.class, version="${project.version}")
public interface SettlementInformation extends RosettaModelObject {

	SettlementInformationMeta metaData = new SettlementInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An optional element used to describe how a trade will settle. This defines a scheme and is used for identifying trades that are identified as settling standard and/or flagged for settlement netting.
	 */
	StandardSettlementStyleEnum getStandardSettlementStyle();
	/**
	 * An explicit specification of how a currency payment is to be made, when the payment is not netted and the route is other than the recipient&#39;s standard settlement instruction.
	 */
	SettlementInstruction getSettlementInstruction();

	/*********************** Build Methods  ***********************/
	SettlementInformation build();
	
	SettlementInformation.SettlementInformationBuilder toBuilder();
	
	static SettlementInformation.SettlementInformationBuilder builder() {
		return new SettlementInformation.SettlementInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementInformation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementInformation> getType() {
		return SettlementInformation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("standardSettlementStyle"), StandardSettlementStyleEnum.class, getStandardSettlementStyle(), this);
		processRosetta(path.newSubPath("settlementInstruction"), processor, SettlementInstruction.class, getSettlementInstruction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementInformationBuilder extends SettlementInformation, RosettaModelObjectBuilder {
		SettlementInstruction.SettlementInstructionBuilder getOrCreateSettlementInstruction();
		SettlementInstruction.SettlementInstructionBuilder getSettlementInstruction();
		SettlementInformation.SettlementInformationBuilder setStandardSettlementStyle(StandardSettlementStyleEnum standardSettlementStyle);
		SettlementInformation.SettlementInformationBuilder setSettlementInstruction(SettlementInstruction settlementInstruction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("standardSettlementStyle"), StandardSettlementStyleEnum.class, getStandardSettlementStyle(), this);
			processRosetta(path.newSubPath("settlementInstruction"), processor, SettlementInstruction.SettlementInstructionBuilder.class, getSettlementInstruction());
		}
		

		SettlementInformation.SettlementInformationBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementInformation  ***********************/
	class SettlementInformationImpl implements SettlementInformation {
		private final StandardSettlementStyleEnum standardSettlementStyle;
		private final SettlementInstruction settlementInstruction;
		
		protected SettlementInformationImpl(SettlementInformation.SettlementInformationBuilder builder) {
			this.standardSettlementStyle = builder.getStandardSettlementStyle();
			this.settlementInstruction = ofNullable(builder.getSettlementInstruction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("standardSettlementStyle")
		public StandardSettlementStyleEnum getStandardSettlementStyle() {
			return standardSettlementStyle;
		}
		
		@Override
		@RosettaAttribute("settlementInstruction")
		public SettlementInstruction getSettlementInstruction() {
			return settlementInstruction;
		}
		
		@Override
		public SettlementInformation build() {
			return this;
		}
		
		@Override
		public SettlementInformation.SettlementInformationBuilder toBuilder() {
			SettlementInformation.SettlementInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementInformation.SettlementInformationBuilder builder) {
			ofNullable(getStandardSettlementStyle()).ifPresent(builder::setStandardSettlementStyle);
			ofNullable(getSettlementInstruction()).ifPresent(builder::setSettlementInstruction);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementInformation _that = getType().cast(o);
		
			if (!Objects.equals(standardSettlementStyle, _that.getStandardSettlementStyle())) return false;
			if (!Objects.equals(settlementInstruction, _that.getSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardSettlementStyle != null ? standardSettlementStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementInstruction != null ? settlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInformation {" +
				"standardSettlementStyle=" + this.standardSettlementStyle + ", " +
				"settlementInstruction=" + this.settlementInstruction +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementInformation  ***********************/
	class SettlementInformationBuilderImpl implements SettlementInformation.SettlementInformationBuilder {
	
		protected StandardSettlementStyleEnum standardSettlementStyle;
		protected SettlementInstruction.SettlementInstructionBuilder settlementInstruction;
	
		public SettlementInformationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("standardSettlementStyle")
		public StandardSettlementStyleEnum getStandardSettlementStyle() {
			return standardSettlementStyle;
		}
		
		@Override
		@RosettaAttribute("settlementInstruction")
		public SettlementInstruction.SettlementInstructionBuilder getSettlementInstruction() {
			return settlementInstruction;
		}
		
		@Override
		public SettlementInstruction.SettlementInstructionBuilder getOrCreateSettlementInstruction() {
			SettlementInstruction.SettlementInstructionBuilder result;
			if (settlementInstruction!=null) {
				result = settlementInstruction;
			}
			else {
				result = settlementInstruction = SettlementInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("standardSettlementStyle")
		public SettlementInformation.SettlementInformationBuilder setStandardSettlementStyle(StandardSettlementStyleEnum standardSettlementStyle) {
			this.standardSettlementStyle = standardSettlementStyle==null?null:standardSettlementStyle;
			return this;
		}
		@Override
		@RosettaAttribute("settlementInstruction")
		public SettlementInformation.SettlementInformationBuilder setSettlementInstruction(SettlementInstruction settlementInstruction) {
			this.settlementInstruction = settlementInstruction==null?null:settlementInstruction.toBuilder();
			return this;
		}
		
		@Override
		public SettlementInformation build() {
			return new SettlementInformation.SettlementInformationImpl(this);
		}
		
		@Override
		public SettlementInformation.SettlementInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInformation.SettlementInformationBuilder prune() {
			if (settlementInstruction!=null && !settlementInstruction.prune().hasData()) settlementInstruction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardSettlementStyle()!=null) return true;
			if (getSettlementInstruction()!=null && getSettlementInstruction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInformation.SettlementInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementInformation.SettlementInformationBuilder o = (SettlementInformation.SettlementInformationBuilder) other;
			
			merger.mergeRosetta(getSettlementInstruction(), o.getSettlementInstruction(), this::setSettlementInstruction);
			
			merger.mergeBasic(getStandardSettlementStyle(), o.getStandardSettlementStyle(), this::setStandardSettlementStyle);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementInformation _that = getType().cast(o);
		
			if (!Objects.equals(standardSettlementStyle, _that.getStandardSettlementStyle())) return false;
			if (!Objects.equals(settlementInstruction, _that.getSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardSettlementStyle != null ? standardSettlementStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementInstruction != null ? settlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInformationBuilder {" +
				"standardSettlementStyle=" + this.standardSettlementStyle + ", " +
				"settlementInstruction=" + this.settlementInstruction +
			'}';
		}
	}
}
