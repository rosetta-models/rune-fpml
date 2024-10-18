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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.DirectionalLeg;
import fpml.confirmation.DirectionalLeg.DirectionalLegBuilder;
import fpml.confirmation.DirectionalLeg.DirectionalLegBuilderImpl;
import fpml.confirmation.DirectionalLeg.DirectionalLegImpl;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.ReturnSwapLeg;
import fpml.confirmation.ReturnSwapLeg.ReturnSwapLegBuilder;
import fpml.confirmation.ReturnSwapLeg.ReturnSwapLegBuilderImpl;
import fpml.confirmation.ReturnSwapLeg.ReturnSwapLegImpl;
import fpml.confirmation.meta.ReturnSwapLegMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An placeholder for the actual Return Swap Leg definition.
 * @version ${project.version}
 */
@RosettaDataType(value="ReturnSwapLeg", builder=ReturnSwapLeg.ReturnSwapLegBuilderImpl.class, version="${project.version}")
public interface ReturnSwapLeg extends DirectionalLeg {

	ReturnSwapLegMeta metaData = new ReturnSwapLegMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ReturnSwapLeg build();
	
	ReturnSwapLeg.ReturnSwapLegBuilder toBuilder();
	
	static ReturnSwapLeg.ReturnSwapLegBuilder builder() {
		return new ReturnSwapLeg.ReturnSwapLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnSwapLeg> getType() {
		return ReturnSwapLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapLegBuilder extends ReturnSwapLeg, DirectionalLeg.DirectionalLegBuilder {
		ReturnSwapLeg.ReturnSwapLegBuilder setId(String id);
		ReturnSwapLeg.ReturnSwapLegBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		ReturnSwapLeg.ReturnSwapLegBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		ReturnSwapLeg.ReturnSwapLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		ReturnSwapLeg.ReturnSwapLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		ReturnSwapLeg.ReturnSwapLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		ReturnSwapLeg.ReturnSwapLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		ReturnSwapLeg.ReturnSwapLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
		}
		

		ReturnSwapLeg.ReturnSwapLegBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapLeg  ***********************/
	class ReturnSwapLegImpl extends DirectionalLeg.DirectionalLegImpl implements ReturnSwapLeg {
		
		protected ReturnSwapLegImpl(ReturnSwapLeg.ReturnSwapLegBuilder builder) {
			super(builder);
		}
		
		@Override
		public ReturnSwapLeg build() {
			return this;
		}
		
		@Override
		public ReturnSwapLeg.ReturnSwapLegBuilder toBuilder() {
			ReturnSwapLeg.ReturnSwapLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapLeg.ReturnSwapLegBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapLeg {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwapLeg  ***********************/
	class ReturnSwapLegBuilderImpl extends DirectionalLeg.DirectionalLegBuilderImpl  implements ReturnSwapLeg.ReturnSwapLegBuilder {
	
	
		public ReturnSwapLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public ReturnSwapLeg.ReturnSwapLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("legIdentifier")
		public ReturnSwapLeg.ReturnSwapLegBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwapLeg.ReturnSwapLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public ReturnSwapLeg.ReturnSwapLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ReturnSwapLeg.ReturnSwapLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers == null)  {
				this.legIdentifier = new ArrayList<>();
			}
			else {
				this.legIdentifier = legIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public ReturnSwapLeg.ReturnSwapLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public ReturnSwapLeg.ReturnSwapLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public ReturnSwapLeg.ReturnSwapLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		
		@Override
		public ReturnSwapLeg build() {
			return new ReturnSwapLeg.ReturnSwapLegImpl(this);
		}
		
		@Override
		public ReturnSwapLeg.ReturnSwapLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapLeg.ReturnSwapLegBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapLeg.ReturnSwapLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ReturnSwapLeg.ReturnSwapLegBuilder o = (ReturnSwapLeg.ReturnSwapLegBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapLegBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
