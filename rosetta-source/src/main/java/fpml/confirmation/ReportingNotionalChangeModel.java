package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AmountRef;
import fpml.confirmation.MoneyRef;
import fpml.confirmation.NotionalChangeEnum;
import fpml.confirmation.ReportingNotionalChangeModel;
import fpml.confirmation.ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder;
import fpml.confirmation.ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilderImpl;
import fpml.confirmation.ReportingNotionalChangeModel.ReportingNotionalChangeModelImpl;
import fpml.confirmation.UnitQuantityRef;
import fpml.confirmation.meta.ReportingNotionalChangeModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ReportingNotionalChangeModel", builder=ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilderImpl.class, version="${project.version}")
public interface ReportingNotionalChangeModel extends RosettaModelObject {

	ReportingNotionalChangeModelMeta metaData = new ReportingNotionalChangeModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indication as to whether the transaction is an increase or decrease of notional of a derivative contract. Only applies when there is change in notional for a derivative contract
	 */
	NotionalChangeEnum getNotionalChange();
	/**
	 * The change in notional amount for a prior report as a result of this event. The current notional will be reported in the trade itself. This corresponds to MiFIR Nominal or Monetary amount values; these can be distinguished by the esmaNotionalType indicator.
	 */
	List<? extends MoneyRef> getChangeInNotional();
	/**
	 * The change in nominal amount from a prior report as a result of this event. The current number of options will be reported in the trade itself. This corresponds to the MiFIR &quot;units&quot; value.
	 */
	List<? extends AmountRef> getChangeInNumberOfOptions();
	/**
	 * The change in quantity(s) from a prior report as a result of this event. The current quantity will be reported in the trade itself. This corresponds to the MiFIR &quot;units&quot; value.
	 */
	List<? extends UnitQuantityRef> getChangeInQuantity();

	/*********************** Build Methods  ***********************/
	ReportingNotionalChangeModel build();
	
	ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder toBuilder();
	
	static ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder builder() {
		return new ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingNotionalChangeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportingNotionalChangeModel> getType() {
		return ReportingNotionalChangeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("notionalChange"), NotionalChangeEnum.class, getNotionalChange(), this);
		processRosetta(path.newSubPath("changeInNotional"), processor, MoneyRef.class, getChangeInNotional());
		processRosetta(path.newSubPath("changeInNumberOfOptions"), processor, AmountRef.class, getChangeInNumberOfOptions());
		processRosetta(path.newSubPath("changeInQuantity"), processor, UnitQuantityRef.class, getChangeInQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingNotionalChangeModelBuilder extends ReportingNotionalChangeModel, RosettaModelObjectBuilder {
		MoneyRef.MoneyRefBuilder getOrCreateChangeInNotional(int _index);
		List<? extends MoneyRef.MoneyRefBuilder> getChangeInNotional();
		AmountRef.AmountRefBuilder getOrCreateChangeInNumberOfOptions(int _index);
		List<? extends AmountRef.AmountRefBuilder> getChangeInNumberOfOptions();
		UnitQuantityRef.UnitQuantityRefBuilder getOrCreateChangeInQuantity(int _index);
		List<? extends UnitQuantityRef.UnitQuantityRefBuilder> getChangeInQuantity();
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder setNotionalChange(NotionalChangeEnum notionalChange);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNotional(MoneyRef changeInNotional0);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNotional(MoneyRef changeInNotional1, int _idx);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNotional(List<? extends MoneyRef> changeInNotional2);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder setChangeInNotional(List<? extends MoneyRef> changeInNotional3);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNumberOfOptions(AmountRef changeInNumberOfOptions0);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNumberOfOptions(AmountRef changeInNumberOfOptions1, int _idx);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptions2);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder setChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptions3);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInQuantity(UnitQuantityRef changeInQuantity0);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInQuantity(UnitQuantityRef changeInQuantity1, int _idx);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantity2);
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder setChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantity3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("notionalChange"), NotionalChangeEnum.class, getNotionalChange(), this);
			processRosetta(path.newSubPath("changeInNotional"), processor, MoneyRef.MoneyRefBuilder.class, getChangeInNotional());
			processRosetta(path.newSubPath("changeInNumberOfOptions"), processor, AmountRef.AmountRefBuilder.class, getChangeInNumberOfOptions());
			processRosetta(path.newSubPath("changeInQuantity"), processor, UnitQuantityRef.UnitQuantityRefBuilder.class, getChangeInQuantity());
		}
		

		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingNotionalChangeModel  ***********************/
	class ReportingNotionalChangeModelImpl implements ReportingNotionalChangeModel {
		private final NotionalChangeEnum notionalChange;
		private final List<? extends MoneyRef> changeInNotional;
		private final List<? extends AmountRef> changeInNumberOfOptions;
		private final List<? extends UnitQuantityRef> changeInQuantity;
		
		protected ReportingNotionalChangeModelImpl(ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder builder) {
			this.notionalChange = builder.getNotionalChange();
			this.changeInNotional = ofNullable(builder.getChangeInNotional()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.changeInNumberOfOptions = ofNullable(builder.getChangeInNumberOfOptions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.changeInQuantity = ofNullable(builder.getChangeInQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalChange")
		public NotionalChangeEnum getNotionalChange() {
			return notionalChange;
		}
		
		@Override
		@RosettaAttribute("changeInNotional")
		public List<? extends MoneyRef> getChangeInNotional() {
			return changeInNotional;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		public List<? extends AmountRef> getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("changeInQuantity")
		public List<? extends UnitQuantityRef> getChangeInQuantity() {
			return changeInQuantity;
		}
		
		@Override
		public ReportingNotionalChangeModel build() {
			return this;
		}
		
		@Override
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder toBuilder() {
			ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder builder) {
			ofNullable(getNotionalChange()).ifPresent(builder::setNotionalChange);
			ofNullable(getChangeInNotional()).ifPresent(builder::setChangeInNotional);
			ofNullable(getChangeInNumberOfOptions()).ifPresent(builder::setChangeInNumberOfOptions);
			ofNullable(getChangeInQuantity()).ifPresent(builder::setChangeInQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingNotionalChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(notionalChange, _that.getNotionalChange())) return false;
			if (!ListEquals.listEquals(changeInNotional, _that.getChangeInNotional())) return false;
			if (!ListEquals.listEquals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!ListEquals.listEquals(changeInQuantity, _that.getChangeInQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalChange != null ? notionalChange.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (changeInNotional != null ? changeInNotional.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (changeInQuantity != null ? changeInQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingNotionalChangeModel {" +
				"notionalChange=" + this.notionalChange + ", " +
				"changeInNotional=" + this.changeInNotional + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"changeInQuantity=" + this.changeInQuantity +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingNotionalChangeModel  ***********************/
	class ReportingNotionalChangeModelBuilderImpl implements ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder {
	
		protected NotionalChangeEnum notionalChange;
		protected List<MoneyRef.MoneyRefBuilder> changeInNotional = new ArrayList<>();
		protected List<AmountRef.AmountRefBuilder> changeInNumberOfOptions = new ArrayList<>();
		protected List<UnitQuantityRef.UnitQuantityRefBuilder> changeInQuantity = new ArrayList<>();
	
		public ReportingNotionalChangeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalChange")
		public NotionalChangeEnum getNotionalChange() {
			return notionalChange;
		}
		
		@Override
		@RosettaAttribute("changeInNotional")
		public List<? extends MoneyRef.MoneyRefBuilder> getChangeInNotional() {
			return changeInNotional;
		}
		
		public MoneyRef.MoneyRefBuilder getOrCreateChangeInNotional(int _index) {
		
			if (changeInNotional==null) {
				this.changeInNotional = new ArrayList<>();
			}
			MoneyRef.MoneyRefBuilder result;
			return getIndex(changeInNotional, _index, () -> {
						MoneyRef.MoneyRefBuilder newChangeInNotional = MoneyRef.builder();
						return newChangeInNotional;
					});
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		public List<? extends AmountRef.AmountRefBuilder> getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		public AmountRef.AmountRefBuilder getOrCreateChangeInNumberOfOptions(int _index) {
		
			if (changeInNumberOfOptions==null) {
				this.changeInNumberOfOptions = new ArrayList<>();
			}
			AmountRef.AmountRefBuilder result;
			return getIndex(changeInNumberOfOptions, _index, () -> {
						AmountRef.AmountRefBuilder newChangeInNumberOfOptions = AmountRef.builder();
						return newChangeInNumberOfOptions;
					});
		}
		
		@Override
		@RosettaAttribute("changeInQuantity")
		public List<? extends UnitQuantityRef.UnitQuantityRefBuilder> getChangeInQuantity() {
			return changeInQuantity;
		}
		
		public UnitQuantityRef.UnitQuantityRefBuilder getOrCreateChangeInQuantity(int _index) {
		
			if (changeInQuantity==null) {
				this.changeInQuantity = new ArrayList<>();
			}
			UnitQuantityRef.UnitQuantityRefBuilder result;
			return getIndex(changeInQuantity, _index, () -> {
						UnitQuantityRef.UnitQuantityRefBuilder newChangeInQuantity = UnitQuantityRef.builder();
						return newChangeInQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("notionalChange")
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder setNotionalChange(NotionalChangeEnum notionalChange) {
			this.notionalChange = notionalChange==null?null:notionalChange;
			return this;
		}
		@Override
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNotional(MoneyRef changeInNotional) {
			if (changeInNotional!=null) this.changeInNotional.add(changeInNotional.toBuilder());
			return this;
		}
		
		@Override
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNotional(MoneyRef changeInNotional, int _idx) {
			getIndex(this.changeInNotional, _idx, () -> changeInNotional.toBuilder());
			return this;
		}
		@Override 
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNotional(List<? extends MoneyRef> changeInNotionals) {
			if (changeInNotionals != null) {
				for (MoneyRef toAdd : changeInNotionals) {
					this.changeInNotional.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("changeInNotional")
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder setChangeInNotional(List<? extends MoneyRef> changeInNotionals) {
			if (changeInNotionals == null)  {
				this.changeInNotional = new ArrayList<>();
			}
			else {
				this.changeInNotional = changeInNotionals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNumberOfOptions(AmountRef changeInNumberOfOptions) {
			if (changeInNumberOfOptions!=null) this.changeInNumberOfOptions.add(changeInNumberOfOptions.toBuilder());
			return this;
		}
		
		@Override
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNumberOfOptions(AmountRef changeInNumberOfOptions, int _idx) {
			getIndex(this.changeInNumberOfOptions, _idx, () -> changeInNumberOfOptions.toBuilder());
			return this;
		}
		@Override 
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptionss) {
			if (changeInNumberOfOptionss != null) {
				for (AmountRef toAdd : changeInNumberOfOptionss) {
					this.changeInNumberOfOptions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("changeInNumberOfOptions")
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder setChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptionss) {
			if (changeInNumberOfOptionss == null)  {
				this.changeInNumberOfOptions = new ArrayList<>();
			}
			else {
				this.changeInNumberOfOptions = changeInNumberOfOptionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInQuantity(UnitQuantityRef changeInQuantity) {
			if (changeInQuantity!=null) this.changeInQuantity.add(changeInQuantity.toBuilder());
			return this;
		}
		
		@Override
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInQuantity(UnitQuantityRef changeInQuantity, int _idx) {
			getIndex(this.changeInQuantity, _idx, () -> changeInQuantity.toBuilder());
			return this;
		}
		@Override 
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder addChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantitys) {
			if (changeInQuantitys != null) {
				for (UnitQuantityRef toAdd : changeInQuantitys) {
					this.changeInQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("changeInQuantity")
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder setChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantitys) {
			if (changeInQuantitys == null)  {
				this.changeInQuantity = new ArrayList<>();
			}
			else {
				this.changeInQuantity = changeInQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ReportingNotionalChangeModel build() {
			return new ReportingNotionalChangeModel.ReportingNotionalChangeModelImpl(this);
		}
		
		@Override
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder prune() {
			changeInNotional = changeInNotional.stream().filter(b->b!=null).<MoneyRef.MoneyRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			changeInNumberOfOptions = changeInNumberOfOptions.stream().filter(b->b!=null).<AmountRef.AmountRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			changeInQuantity = changeInQuantity.stream().filter(b->b!=null).<UnitQuantityRef.UnitQuantityRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalChange()!=null) return true;
			if (getChangeInNotional()!=null && getChangeInNotional().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChangeInNumberOfOptions()!=null && getChangeInNumberOfOptions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChangeInQuantity()!=null && getChangeInQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder o = (ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder) other;
			
			merger.mergeRosetta(getChangeInNotional(), o.getChangeInNotional(), this::getOrCreateChangeInNotional);
			merger.mergeRosetta(getChangeInNumberOfOptions(), o.getChangeInNumberOfOptions(), this::getOrCreateChangeInNumberOfOptions);
			merger.mergeRosetta(getChangeInQuantity(), o.getChangeInQuantity(), this::getOrCreateChangeInQuantity);
			
			merger.mergeBasic(getNotionalChange(), o.getNotionalChange(), this::setNotionalChange);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingNotionalChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(notionalChange, _that.getNotionalChange())) return false;
			if (!ListEquals.listEquals(changeInNotional, _that.getChangeInNotional())) return false;
			if (!ListEquals.listEquals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!ListEquals.listEquals(changeInQuantity, _that.getChangeInQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalChange != null ? notionalChange.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (changeInNotional != null ? changeInNotional.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (changeInQuantity != null ? changeInQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingNotionalChangeModelBuilder {" +
				"notionalChange=" + this.notionalChange + ", " +
				"changeInNotional=" + this.changeInNotional + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"changeInQuantity=" + this.changeInQuantity +
			'}';
		}
	}
}
