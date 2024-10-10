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
import fpml.confirmation.TradeReferenceInformation;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.TradeReferenceInformationModel.TradeReferenceInformationModelBuilder;
import fpml.confirmation.TradeReferenceInformationModel.TradeReferenceInformationModelBuilderImpl;
import fpml.confirmation.TradeReferenceInformationModel.TradeReferenceInformationModelImpl;
import fpml.confirmation.meta.TradeReferenceInformationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a model group that allows information about a trade to be represented.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeReferenceInformationModel", builder=TradeReferenceInformationModel.TradeReferenceInformationModelBuilderImpl.class, version="${project.version}")
public interface TradeReferenceInformationModel extends RosettaModelObject {

	TradeReferenceInformationModelMeta metaData = new TradeReferenceInformationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Information about a trade.
	 */
	TradeReferenceInformation getTradeReferenceInformation();

	/*********************** Build Methods  ***********************/
	TradeReferenceInformationModel build();
	
	TradeReferenceInformationModel.TradeReferenceInformationModelBuilder toBuilder();
	
	static TradeReferenceInformationModel.TradeReferenceInformationModelBuilder builder() {
		return new TradeReferenceInformationModel.TradeReferenceInformationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReferenceInformationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeReferenceInformationModel> getType() {
		return TradeReferenceInformationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.class, getTradeReferenceInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeReferenceInformationModelBuilder extends TradeReferenceInformationModel, RosettaModelObjectBuilder {
		TradeReferenceInformation.TradeReferenceInformationBuilder getOrCreateTradeReferenceInformation();
		TradeReferenceInformation.TradeReferenceInformationBuilder getTradeReferenceInformation();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder setTradeReferenceInformation(TradeReferenceInformation tradeReferenceInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.TradeReferenceInformationBuilder.class, getTradeReferenceInformation());
		}
		

		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradeReferenceInformationModel  ***********************/
	class TradeReferenceInformationModelImpl implements TradeReferenceInformationModel {
		private final TradeReferenceInformation tradeReferenceInformation;
		
		protected TradeReferenceInformationModelImpl(TradeReferenceInformationModel.TradeReferenceInformationModelBuilder builder) {
			this.tradeReferenceInformation = ofNullable(builder.getTradeReferenceInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformation")
		public TradeReferenceInformation getTradeReferenceInformation() {
			return tradeReferenceInformation;
		}
		
		@Override
		public TradeReferenceInformationModel build() {
			return this;
		}
		
		@Override
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder toBuilder() {
			TradeReferenceInformationModel.TradeReferenceInformationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReferenceInformationModel.TradeReferenceInformationModelBuilder builder) {
			ofNullable(getTradeReferenceInformation()).ifPresent(builder::setTradeReferenceInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReferenceInformationModel _that = getType().cast(o);
		
			if (!Objects.equals(tradeReferenceInformation, _that.getTradeReferenceInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeReferenceInformation != null ? tradeReferenceInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReferenceInformationModel {" +
				"tradeReferenceInformation=" + this.tradeReferenceInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeReferenceInformationModel  ***********************/
	class TradeReferenceInformationModelBuilderImpl implements TradeReferenceInformationModel.TradeReferenceInformationModelBuilder {
	
		protected TradeReferenceInformation.TradeReferenceInformationBuilder tradeReferenceInformation;
	
		public TradeReferenceInformationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeReferenceInformation")
		public TradeReferenceInformation.TradeReferenceInformationBuilder getTradeReferenceInformation() {
			return tradeReferenceInformation;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder getOrCreateTradeReferenceInformation() {
			TradeReferenceInformation.TradeReferenceInformationBuilder result;
			if (tradeReferenceInformation!=null) {
				result = tradeReferenceInformation;
			}
			else {
				result = tradeReferenceInformation = TradeReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformation")
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder setTradeReferenceInformation(TradeReferenceInformation tradeReferenceInformation) {
			this.tradeReferenceInformation = tradeReferenceInformation==null?null:tradeReferenceInformation.toBuilder();
			return this;
		}
		
		@Override
		public TradeReferenceInformationModel build() {
			return new TradeReferenceInformationModel.TradeReferenceInformationModelImpl(this);
		}
		
		@Override
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder prune() {
			if (tradeReferenceInformation!=null && !tradeReferenceInformation.prune().hasData()) tradeReferenceInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeReferenceInformation()!=null && getTradeReferenceInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeReferenceInformationModel.TradeReferenceInformationModelBuilder o = (TradeReferenceInformationModel.TradeReferenceInformationModelBuilder) other;
			
			merger.mergeRosetta(getTradeReferenceInformation(), o.getTradeReferenceInformation(), this::setTradeReferenceInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReferenceInformationModel _that = getType().cast(o);
		
			if (!Objects.equals(tradeReferenceInformation, _that.getTradeReferenceInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeReferenceInformation != null ? tradeReferenceInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReferenceInformationModelBuilder {" +
				"tradeReferenceInformation=" + this.tradeReferenceInformation +
			'}';
		}
	}
}
