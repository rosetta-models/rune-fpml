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
import fpml.confirmation.TradeNotionalChangeModel;
import fpml.confirmation.TradeNotionalChangeModel.TradeNotionalChangeModelBuilder;
import fpml.confirmation.TradeNotionalChangeModel.TradeNotionalChangeModelBuilderImpl;
import fpml.confirmation.TradeNotionalChangeModel.TradeNotionalChangeModelImpl;
import fpml.confirmation.TradeNotionalChangeModelSequence0;
import fpml.confirmation.TradeNotionalChangeModelSequence1;
import fpml.confirmation.TradeNotionalChangeModelSequence2;
import fpml.confirmation.meta.TradeNotionalChangeModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * DEPRECATED. A structure describing a change to the trade notional.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeNotionalChangeModel", builder=TradeNotionalChangeModel.TradeNotionalChangeModelBuilderImpl.class, version="${project.version}")
public interface TradeNotionalChangeModel extends RosettaModelObject {

	TradeNotionalChangeModelMeta metaData = new TradeNotionalChangeModelMeta();

	/*********************** Getter Methods  ***********************/
	TradeNotionalChangeModelSequence0 getTradeNotionalChangeModelSequence0();
	TradeNotionalChangeModelSequence1 getTradeNotionalChangeModelSequence1();
	TradeNotionalChangeModelSequence2 getTradeNotionalChangeModelSequence2();

	/*********************** Build Methods  ***********************/
	TradeNotionalChangeModel build();
	
	TradeNotionalChangeModel.TradeNotionalChangeModelBuilder toBuilder();
	
	static TradeNotionalChangeModel.TradeNotionalChangeModelBuilder builder() {
		return new TradeNotionalChangeModel.TradeNotionalChangeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeNotionalChangeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeNotionalChangeModel> getType() {
		return TradeNotionalChangeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeNotionalChangeModelSequence0"), processor, TradeNotionalChangeModelSequence0.class, getTradeNotionalChangeModelSequence0());
		processRosetta(path.newSubPath("tradeNotionalChangeModelSequence1"), processor, TradeNotionalChangeModelSequence1.class, getTradeNotionalChangeModelSequence1());
		processRosetta(path.newSubPath("tradeNotionalChangeModelSequence2"), processor, TradeNotionalChangeModelSequence2.class, getTradeNotionalChangeModelSequence2());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeNotionalChangeModelBuilder extends TradeNotionalChangeModel, RosettaModelObjectBuilder {
		TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder getOrCreateTradeNotionalChangeModelSequence0();
		TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder getTradeNotionalChangeModelSequence0();
		TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder getOrCreateTradeNotionalChangeModelSequence1();
		TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder getTradeNotionalChangeModelSequence1();
		TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder getOrCreateTradeNotionalChangeModelSequence2();
		TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder getTradeNotionalChangeModelSequence2();
		TradeNotionalChangeModel.TradeNotionalChangeModelBuilder setTradeNotionalChangeModelSequence0(TradeNotionalChangeModelSequence0 tradeNotionalChangeModelSequence0);
		TradeNotionalChangeModel.TradeNotionalChangeModelBuilder setTradeNotionalChangeModelSequence1(TradeNotionalChangeModelSequence1 tradeNotionalChangeModelSequence1);
		TradeNotionalChangeModel.TradeNotionalChangeModelBuilder setTradeNotionalChangeModelSequence2(TradeNotionalChangeModelSequence2 tradeNotionalChangeModelSequence2);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeNotionalChangeModelSequence0"), processor, TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder.class, getTradeNotionalChangeModelSequence0());
			processRosetta(path.newSubPath("tradeNotionalChangeModelSequence1"), processor, TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder.class, getTradeNotionalChangeModelSequence1());
			processRosetta(path.newSubPath("tradeNotionalChangeModelSequence2"), processor, TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder.class, getTradeNotionalChangeModelSequence2());
		}
		

		TradeNotionalChangeModel.TradeNotionalChangeModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradeNotionalChangeModel  ***********************/
	class TradeNotionalChangeModelImpl implements TradeNotionalChangeModel {
		private final TradeNotionalChangeModelSequence0 tradeNotionalChangeModelSequence0;
		private final TradeNotionalChangeModelSequence1 tradeNotionalChangeModelSequence1;
		private final TradeNotionalChangeModelSequence2 tradeNotionalChangeModelSequence2;
		
		protected TradeNotionalChangeModelImpl(TradeNotionalChangeModel.TradeNotionalChangeModelBuilder builder) {
			this.tradeNotionalChangeModelSequence0 = ofNullable(builder.getTradeNotionalChangeModelSequence0()).map(f->f.build()).orElse(null);
			this.tradeNotionalChangeModelSequence1 = ofNullable(builder.getTradeNotionalChangeModelSequence1()).map(f->f.build()).orElse(null);
			this.tradeNotionalChangeModelSequence2 = ofNullable(builder.getTradeNotionalChangeModelSequence2()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeNotionalChangeModelSequence0")
		public TradeNotionalChangeModelSequence0 getTradeNotionalChangeModelSequence0() {
			return tradeNotionalChangeModelSequence0;
		}
		
		@Override
		@RosettaAttribute("tradeNotionalChangeModelSequence1")
		public TradeNotionalChangeModelSequence1 getTradeNotionalChangeModelSequence1() {
			return tradeNotionalChangeModelSequence1;
		}
		
		@Override
		@RosettaAttribute("tradeNotionalChangeModelSequence2")
		public TradeNotionalChangeModelSequence2 getTradeNotionalChangeModelSequence2() {
			return tradeNotionalChangeModelSequence2;
		}
		
		@Override
		public TradeNotionalChangeModel build() {
			return this;
		}
		
		@Override
		public TradeNotionalChangeModel.TradeNotionalChangeModelBuilder toBuilder() {
			TradeNotionalChangeModel.TradeNotionalChangeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeNotionalChangeModel.TradeNotionalChangeModelBuilder builder) {
			ofNullable(getTradeNotionalChangeModelSequence0()).ifPresent(builder::setTradeNotionalChangeModelSequence0);
			ofNullable(getTradeNotionalChangeModelSequence1()).ifPresent(builder::setTradeNotionalChangeModelSequence1);
			ofNullable(getTradeNotionalChangeModelSequence2()).ifPresent(builder::setTradeNotionalChangeModelSequence2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNotionalChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(tradeNotionalChangeModelSequence0, _that.getTradeNotionalChangeModelSequence0())) return false;
			if (!Objects.equals(tradeNotionalChangeModelSequence1, _that.getTradeNotionalChangeModelSequence1())) return false;
			if (!Objects.equals(tradeNotionalChangeModelSequence2, _that.getTradeNotionalChangeModelSequence2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeNotionalChangeModelSequence0 != null ? tradeNotionalChangeModelSequence0.hashCode() : 0);
			_result = 31 * _result + (tradeNotionalChangeModelSequence1 != null ? tradeNotionalChangeModelSequence1.hashCode() : 0);
			_result = 31 * _result + (tradeNotionalChangeModelSequence2 != null ? tradeNotionalChangeModelSequence2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChangeModel {" +
				"tradeNotionalChangeModelSequence0=" + this.tradeNotionalChangeModelSequence0 + ", " +
				"tradeNotionalChangeModelSequence1=" + this.tradeNotionalChangeModelSequence1 + ", " +
				"tradeNotionalChangeModelSequence2=" + this.tradeNotionalChangeModelSequence2 +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeNotionalChangeModel  ***********************/
	class TradeNotionalChangeModelBuilderImpl implements TradeNotionalChangeModel.TradeNotionalChangeModelBuilder {
	
		protected TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder tradeNotionalChangeModelSequence0;
		protected TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder tradeNotionalChangeModelSequence1;
		protected TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder tradeNotionalChangeModelSequence2;
	
		public TradeNotionalChangeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeNotionalChangeModelSequence0")
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder getTradeNotionalChangeModelSequence0() {
			return tradeNotionalChangeModelSequence0;
		}
		
		@Override
		public TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder getOrCreateTradeNotionalChangeModelSequence0() {
			TradeNotionalChangeModelSequence0.TradeNotionalChangeModelSequence0Builder result;
			if (tradeNotionalChangeModelSequence0!=null) {
				result = tradeNotionalChangeModelSequence0;
			}
			else {
				result = tradeNotionalChangeModelSequence0 = TradeNotionalChangeModelSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeNotionalChangeModelSequence1")
		public TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder getTradeNotionalChangeModelSequence1() {
			return tradeNotionalChangeModelSequence1;
		}
		
		@Override
		public TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder getOrCreateTradeNotionalChangeModelSequence1() {
			TradeNotionalChangeModelSequence1.TradeNotionalChangeModelSequence1Builder result;
			if (tradeNotionalChangeModelSequence1!=null) {
				result = tradeNotionalChangeModelSequence1;
			}
			else {
				result = tradeNotionalChangeModelSequence1 = TradeNotionalChangeModelSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeNotionalChangeModelSequence2")
		public TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder getTradeNotionalChangeModelSequence2() {
			return tradeNotionalChangeModelSequence2;
		}
		
		@Override
		public TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder getOrCreateTradeNotionalChangeModelSequence2() {
			TradeNotionalChangeModelSequence2.TradeNotionalChangeModelSequence2Builder result;
			if (tradeNotionalChangeModelSequence2!=null) {
				result = tradeNotionalChangeModelSequence2;
			}
			else {
				result = tradeNotionalChangeModelSequence2 = TradeNotionalChangeModelSequence2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeNotionalChangeModelSequence0")
		public TradeNotionalChangeModel.TradeNotionalChangeModelBuilder setTradeNotionalChangeModelSequence0(TradeNotionalChangeModelSequence0 tradeNotionalChangeModelSequence0) {
			this.tradeNotionalChangeModelSequence0 = tradeNotionalChangeModelSequence0==null?null:tradeNotionalChangeModelSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeNotionalChangeModelSequence1")
		public TradeNotionalChangeModel.TradeNotionalChangeModelBuilder setTradeNotionalChangeModelSequence1(TradeNotionalChangeModelSequence1 tradeNotionalChangeModelSequence1) {
			this.tradeNotionalChangeModelSequence1 = tradeNotionalChangeModelSequence1==null?null:tradeNotionalChangeModelSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeNotionalChangeModelSequence2")
		public TradeNotionalChangeModel.TradeNotionalChangeModelBuilder setTradeNotionalChangeModelSequence2(TradeNotionalChangeModelSequence2 tradeNotionalChangeModelSequence2) {
			this.tradeNotionalChangeModelSequence2 = tradeNotionalChangeModelSequence2==null?null:tradeNotionalChangeModelSequence2.toBuilder();
			return this;
		}
		
		@Override
		public TradeNotionalChangeModel build() {
			return new TradeNotionalChangeModel.TradeNotionalChangeModelImpl(this);
		}
		
		@Override
		public TradeNotionalChangeModel.TradeNotionalChangeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChangeModel.TradeNotionalChangeModelBuilder prune() {
			if (tradeNotionalChangeModelSequence0!=null && !tradeNotionalChangeModelSequence0.prune().hasData()) tradeNotionalChangeModelSequence0 = null;
			if (tradeNotionalChangeModelSequence1!=null && !tradeNotionalChangeModelSequence1.prune().hasData()) tradeNotionalChangeModelSequence1 = null;
			if (tradeNotionalChangeModelSequence2!=null && !tradeNotionalChangeModelSequence2.prune().hasData()) tradeNotionalChangeModelSequence2 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeNotionalChangeModelSequence0()!=null && getTradeNotionalChangeModelSequence0().hasData()) return true;
			if (getTradeNotionalChangeModelSequence1()!=null && getTradeNotionalChangeModelSequence1().hasData()) return true;
			if (getTradeNotionalChangeModelSequence2()!=null && getTradeNotionalChangeModelSequence2().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChangeModel.TradeNotionalChangeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeNotionalChangeModel.TradeNotionalChangeModelBuilder o = (TradeNotionalChangeModel.TradeNotionalChangeModelBuilder) other;
			
			merger.mergeRosetta(getTradeNotionalChangeModelSequence0(), o.getTradeNotionalChangeModelSequence0(), this::setTradeNotionalChangeModelSequence0);
			merger.mergeRosetta(getTradeNotionalChangeModelSequence1(), o.getTradeNotionalChangeModelSequence1(), this::setTradeNotionalChangeModelSequence1);
			merger.mergeRosetta(getTradeNotionalChangeModelSequence2(), o.getTradeNotionalChangeModelSequence2(), this::setTradeNotionalChangeModelSequence2);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNotionalChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(tradeNotionalChangeModelSequence0, _that.getTradeNotionalChangeModelSequence0())) return false;
			if (!Objects.equals(tradeNotionalChangeModelSequence1, _that.getTradeNotionalChangeModelSequence1())) return false;
			if (!Objects.equals(tradeNotionalChangeModelSequence2, _that.getTradeNotionalChangeModelSequence2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeNotionalChangeModelSequence0 != null ? tradeNotionalChangeModelSequence0.hashCode() : 0);
			_result = 31 * _result + (tradeNotionalChangeModelSequence1 != null ? tradeNotionalChangeModelSequence1.hashCode() : 0);
			_result = 31 * _result + (tradeNotionalChangeModelSequence2 != null ? tradeNotionalChangeModelSequence2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChangeModelBuilder {" +
				"tradeNotionalChangeModelSequence0=" + this.tradeNotionalChangeModelSequence0 + ", " +
				"tradeNotionalChangeModelSequence1=" + this.tradeNotionalChangeModelSequence1 + ", " +
				"tradeNotionalChangeModelSequence2=" + this.tradeNotionalChangeModelSequence2 +
			'}';
		}
	}
}
