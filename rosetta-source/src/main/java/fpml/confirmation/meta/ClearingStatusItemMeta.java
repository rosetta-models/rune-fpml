package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingStatusItem;
import fpml.confirmation.validation.ClearingStatusItemTypeFormatValidator;
import fpml.confirmation.validation.ClearingStatusItemValidator;
import fpml.confirmation.validation.exists.ClearingStatusItemOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ClearingStatusItem.class)
public class ClearingStatusItemMeta implements RosettaMetaData<ClearingStatusItem> {

	@Override
	public List<Validator<? super ClearingStatusItem>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ClearingStatusItem>create(fpml.confirmation.validation.datarule.ClearingStatusItemChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ClearingStatusItem, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingStatusItem> validator() {
		return new ClearingStatusItemValidator();
	}

	@Override
	public Validator<? super ClearingStatusItem> typeFormatValidator() {
		return new ClearingStatusItemTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingStatusItem, Set<String>> onlyExistsValidator() {
		return new ClearingStatusItemOnlyExistsValidator();
	}
}
