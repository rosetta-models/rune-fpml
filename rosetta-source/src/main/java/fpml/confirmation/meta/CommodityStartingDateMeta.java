package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityStartingDate;
import fpml.confirmation.validation.CommodityStartingDateTypeFormatValidator;
import fpml.confirmation.validation.CommodityStartingDateValidator;
import fpml.confirmation.validation.exists.CommodityStartingDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityStartingDate.class)
public class CommodityStartingDateMeta implements RosettaMetaData<CommodityStartingDate> {

	@Override
	public List<Validator<? super CommodityStartingDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityStartingDate>create(fpml.confirmation.validation.datarule.CommodityStartingDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityStartingDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityStartingDate> validator() {
		return new CommodityStartingDateValidator();
	}

	@Override
	public Validator<? super CommodityStartingDate> typeFormatValidator() {
		return new CommodityStartingDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityStartingDate, Set<String>> onlyExistsValidator() {
		return new CommodityStartingDateOnlyExistsValidator();
	}
}
